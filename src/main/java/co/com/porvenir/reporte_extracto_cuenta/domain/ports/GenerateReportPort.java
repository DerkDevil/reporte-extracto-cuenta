package co.com.porvenir.reporte_extracto_cuenta.domain.ports;

import java.util.Map;

public interface GenerateReportPort {

    byte[] generateReport(String reportName, Map<String, Object> parameters);
}
