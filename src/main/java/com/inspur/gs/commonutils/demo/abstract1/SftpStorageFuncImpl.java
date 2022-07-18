package com.inspur.gs.commonutils.demo.abstract1;

import com.inspur.edp.svc.document.storage.entity.GspDocMetadata;

public class SftpStorageFuncImpl extends StorageFuncDemo {

    private static SftpStorageFuncImpl instance;

    public static SftpStorageFuncImpl getCurrent() {
        if (instance == null) {
            instance = new SftpStorageFuncImpl();
        }
        return instance;
    }

    @Override
    protected String doUpload(String paramString1, GspDocMetadata paramGspDocMetadata, byte[] paramArrayOfbyte, String paramString2, boolean paramBoolean) {
        return null;
    }

    @Override
    protected boolean doDelete(String paramString1, String paramString2) {
        return false;
    }

    @Override
    protected String doUpdate(String paramString1, GspDocMetadata paramGspDocMetadata, byte[] paramArrayOfbyte) {
        return null;
    }

    @Override
    protected byte[] doGet(String paramString1, String paramString2, Boolean paramBoolean) {
        return new byte[0];
    }


}
