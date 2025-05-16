package co.com.porvenir.reporte_extracto_cuenta.application.ports;

import co.com.porvenir.reporte_extracto_cuenta.adapters.in.web.dto.request.ReporteExtractoCuentaRequestDto;

import java.util.Map;

public interface GenerateReportUseCase {

    byte[] generateReport(ReporteExtractoCuentaRequestDto request);
}