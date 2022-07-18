package com.inspur.gs.commonutils.demo.abstract1;

import com.inspur.edp.svc.document.storage.entity.GspDocMetadata;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * @author tianjinzan01
 */
public interface DocStoragePolicy {

    String upload(String paramString1, GspDocMetadata paramGspDocMetadata, byte[] paramArrayOfbyte, String paramString2, boolean paramBoolean) throws IOException, SftpException, JSchException;

    byte[] get(String paramString1, String paramString2, Boolean paramBoolean) throws IOException, SftpException, JSchException;

    boolean delete(String paramString1, String paramString2) throws MalformedURLException, SftpException, JSchException, UnsupportedEncodingException;

    String update(String paramString, GspDocMetadata paramGspDocMetadata, byte[] paramArrayOfbyte) throws JSchException, SftpException, IOException;

    void clean();
}
