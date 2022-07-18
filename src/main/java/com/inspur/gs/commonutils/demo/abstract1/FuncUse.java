package com.inspur.gs.commonutils.demo.abstract1;

public class FuncUse {

    private final SftpStorageFuncImpl sftpStorage = SftpStorageFuncImpl.getCurrent();

    private final NfsStroageFuncImpl nfsStroage = NfsStroageFuncImpl.getCurrent();

    public void testDemo() {
        DocStoragePolicy storageInstance = getStoragePolicy(1);
        //storageInstance.upload();
    }

    public DocStoragePolicy getStoragePolicy(Integer type) {
        if (type == 1) {
            return this.sftpStorage;
        } else {
            return this.nfsStroage;
        }

    }

}
