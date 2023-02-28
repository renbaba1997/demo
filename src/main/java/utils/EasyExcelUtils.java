package utils;

import com.alibaba.excel.EasyExcel;
import org.burningwave.core.assembler.StaticComponentContainer;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

public class EasyExcelUtils {

    public static <T> void EasyExcelDownload(HttpServletResponse response, Class<T> cls,  List<T> resList, String sheetName) throws IOException {
        StaticComponentContainer.Modules.exportAllToAll();
        String fileName = URLEncoder.encode(sheetName, "utf-8");
        response.setHeader("Content-disposition", new String(fileName.getBytes("utf-8"),"ISO8859-1") + ".xlsx");
        EasyExcel.write(response.getOutputStream(), cls).sheet(sheetName).doWrite(resList);
    }
}
