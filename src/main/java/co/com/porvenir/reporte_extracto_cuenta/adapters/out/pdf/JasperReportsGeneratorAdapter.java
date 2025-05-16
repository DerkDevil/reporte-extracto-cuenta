package co.com.porvenir.reporte_extracto_cuenta.adapters.out.pdf;

import co.com.porvenir.reporte_extracto_cuenta.application.exceptions.PorvenirException;
import co.com.porvenir.reporte_extracto_cuenta.application.exceptions.responsemessages.ReponseMessage;
import co.com.porvenir.reporte_extracto_cuenta.application.ports.GenerateReportUseCase;
import co.com.porvenir.reporte_extracto_cuenta.domain.ports.GenerateReportPort;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.JRLoader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

@Slf4j
@Component
public class JasperReportsGeneratorAdapter implements GenerateReportPort {

    @Override
    public byte[] generateReport(String reportName, Map<String, Object> parameters) {

        var reportBuilded = new ClassPathResource("reports/" + reportName + ".jasper");

        try {
            JasperReport reportEmpty = (JasperReport) JRLoader.loadObject(reportBuilded.getInputStream());
            var reportFilled = JasperFillManager.fillReport(reportEmpty, parameters, new JREmptyDataSource());
            return JasperExportManager.exportReportToPdf(reportFilled);
        } catch (JRException | IOException e) {
            log.error("Error when trying to generate the report");
            throw new PorvenirException(ReponseMessage.INTERNAL_SERVER_ERROR, e);
        }
    }

}
