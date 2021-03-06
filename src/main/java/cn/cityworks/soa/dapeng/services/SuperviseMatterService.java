package cn.cityworks.soa.dapeng.services;

import java.io.*;
import java.util.Map;

/**
 * create by afterloe on 2017/10/17
 */
public interface SuperviseMatterService extends Serializable, Tools {

    /**
     * 督办事项列表
     *
     * @param token
     * @param page
     * @param number
     * @return
     */
    Object listSuperviseMatter(String token, String action, Boolean value, int page, int number);

    /**
     * 获取督办事件 表单
     *
     * @param token
     * @return
     */
    Object getSuperviseMatterFromData(String token);

    /**
     * 上报督办事件
     *
     * @param token
     * @param taskForm
     * @return
     */
    Object saveSuperviseMatter(String token, Map taskForm);

    /**
     * 读取文件信息
     *
     * @param file
     * @return
     */
    default StringBuffer getFormData(File file) {
        BufferedReader bufferedReader = null;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), "utf-8"));
            String line = null;
            while (null != (line = bufferedReader.readLine())) {
                stringBuffer.append(line);
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            if (null != bufferedReader) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            return stringBuffer;
        }
    }
}
