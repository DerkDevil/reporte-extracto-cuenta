package co.com.porvenir.reporte_extracto_cuenta.application.services;

import co.com.porvenir.reporte_extracto_cuenta.adapters.in.web.dto.request.ReporteExtractoCuentaRequestDto;
import co.com.porvenir.reporte_extracto_cuenta.application.ports.GenerateReportUseCase;
import co.com.porvenir.reporte_extracto_cuenta.domain.ports.GenerateReportPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class GenerateReportService implements GenerateReportUseCase {

    private static final String REPORT_NAME = "Reporte_Extracto_cuenta";
    private final GenerateReportPort generatePdfReport;

    @Override
    public byte[] generateReport(ReporteExtractoCuentaRequestDto request) {


        ReporteExtractoCuentaRequestDto extracto = new ReporteExtractoCuentaRequestDto();

        return generatePdfReport.generateReport(REPORT_NAME, null);
    }

}
