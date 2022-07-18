package com.inspur.gs.commonutils.demo.abstract1;

import com.inspur.edp.svc.document.storage.entity.GspDocMetadata;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * 使用场景：提供一个标准附件服务
 * 分析：附件存储协议多样性（sftp,nfs,nio,s3）,实际附件处理只有4种,可抽象为 上传、下载、删除、更新 四个动作
 * 类似场景：营业缴费服务，可抽象为 查账、生成订单、销账三个动作
 *
 * 抽象类
 *
 * * 优点：
 *  * 抽象类存在的意义是被子类继承，否则抽象类将毫无意义，抽象类体现的是模板思想，模板是通用的东西抽象类中已经是具体的实现（抽象类中可以有成员变量和实现方法），
 *  * 而模板中不能决定的东西定义成抽象方法，让使 用模板（继承抽象类的类）的类去重写抽象方法实现需求，这是典型的模板思想。
 *
 * 特点：
 * 1、方法只有声明，没有实现时，该方法就是抽象方法，需要被abstract修饰。
 * 2、抽象类不可以被实例化。因为用抽象方法无意义。
 * 3、抽象类必须由其子类覆盖了所有的抽象方法，该子类才可以被实例化，否则这个子类还是抽象类。
 * 4，抽象类中的抽象方法 : 强制要求子类做的事
 * 5、抽象类中有构造函数，用于给子类初始化。
 * 6、抽象类可以不定义抽象方法，目的是不让该类创建对象。
 * 7、abstract关键字不可以与private、static、final关键字共存。
 *
 */
public abstract class StorageFuncDemo implements DocStoragePolicy {

    @Override
    public String upload(String path, GspDocMetadata metadata, byte[] content, String storageId, boolean handleDoc) {
        return doUpload(path, metadata, content, storageId, handleDoc);
    }

    @Override
    public byte[] get(String fileId, String storageId, Boolean isView) throws IOException, SftpException, JSchException {
        return doGet(fileId, storageId, isView);
    }

    @Override
    public boolean delete(String fileId, String storageId) {
        return doDelete(fileId, storageId);
    }

    @Override
    public String update(String paramString, GspDocMetadata paramGspDocMetadata, byte[] paramArrayOfbyte) {
        return doUpdate(paramString, paramGspDocMetadata, paramArrayOfbyte);
    }

    @Override
    public void clean() {}

    protected abstract String doUpload(String paramString1, GspDocMetadata paramGspDocMetadata, byte[] paramArrayOfbyte, String paramString2, boolean paramBoolean);

    protected abstract boolean doDelete(String paramString1, String paramString2);

    protected abstract String doUpdate(String paramString1, GspDocMetadata paramGspDocMetadata, byte[] paramArrayOfbyte);

    protected abstract byte[] doGet(String paramString1, String paramString2, Boolean paramBoolean);
}
