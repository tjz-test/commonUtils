package com.inspur.gs.commonutils.demo.attachment;

import com.inspur.edp.svc.document.storage.entity.GspDocContent;
import com.inspur.edp.svc.document.storage.entity.GspDocMetadata;
import com.inspur.edp.svc.document.storage.entity.GspDocOperatingModes;
import com.inspur.edp.svc.document.storage.proxy.DocStorageProxyService;
import com.inspur.edp.svc.document.viewer.webapi.GspFileViewerService;
import io.iec.edp.caf.commons.utils.SpringBeanUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * igix 附件使用
 * 上传、下载、删除、更新
 *
 * 附件存储数据库记录表
 * gspdocmetadata
 * id => metadataid
 * docid => 存储路径
 * rootid => 根目录
 * storageid => 存储方式
 *
 * @author tianjinzan01
 */
public class AttachMentDemo {

    //region bean

    /**
     * 文档服务
     */
    private final DocStorageProxyService formDocStorageService;

    /**
     * 构造函数
     */
    public AttachMentDemo() {
        this.formDocStorageService = SpringBeanUtils.getBean(DocStorageProxyService.class);
    }

    public static AttachMentDemo getAttachMent() {
        return new AttachMentDemo();
    }

    /**
     * 上传文件
     * @param rootid 根路径
     * @param fileContent 内容
     * @param doctype 文件类型
     * @param filename 文件命
     * @param foldPath 路径
     * @return gspdocmetadata id
     */
    public String upLoadFile(String rootid, byte[] fileContent, String doctype, String filename, String foldPath) throws IOException {
        //date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date();
        //文件大小
        String size = String.valueOf(fileContent.length);
        GspDocMetadata metadata = new GspDocMetadata();
        String fileId = UUID.randomUUID().toString();
        //根目录
        metadata.setRootId(rootid);
        //附件id
        metadata.setId(fileId);
        //文件大小
        metadata.setDocSize(size);
        //文件类型
        metadata.setDocType(doctype);
        //文件名
        metadata.setFileName(filename);
        //路径拼接
        String path = foldPath + File.separator + sdf.format(date) + File.separator;
        return this.formDocStorageService.uploadDoc(path, metadata, fileContent, GspDocOperatingModes.Formal);
    }

    /**
     * 获取文件信息
     * @param metadataId  gspdocmetadata id
     * @param rootId  根路径
     * @return GspDocContent
     */
    public GspDocContent getFileInfo(String metadataId, String rootId) {
        return this.formDocStorageService.getDocContent(metadataId, rootId);
    }

    /**
     * 删除文件
     * @param rootId document code
     * @param metadataId metadataId
     */
    public boolean removeDocument(String rootId, String metadataId){
        try {
            return this.formDocStorageService.removeDoc(metadataId, GspDocOperatingModes.Formal, rootId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新
     * @param metadataId 附件id
     * @param fileContent 内容
     * @param mode 正式、临时
     * @param rootId rootId
     */
    public boolean updateDocument(String metadataId, byte[] fileContent, GspDocOperatingModes mode, String rootId) {
        try {
            return this.formDocStorageService.updateDoc(metadataId, fileContent, mode, rootId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新文件名和内容
     * @param metadataId 附件id
     * @param fileContent 内容
     * @param fileName 文件明
     * @param mode 正式/临时
     * @param rootId 根目录
     */
    public boolean updateDocWithName(String metadataId, byte[] fileContent, String fileName, GspDocOperatingModes mode, String rootId) {
        try {
            return this.formDocStorageService.updateDocWithName(metadataId, fileContent, fileName, mode, rootId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取文档元数据
     * @param metadataId 附件id
     * @param rootId 跟目录
     * @return 文档记录
     */
    public GspDocMetadata getMetadata(String metadataId, String rootId) {
        try {
            return this.formDocStorageService.getMetadata(metadataId, rootId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取文档元数据
     * @param metadataId 附件id
     * @return 文档记录
     */
    public GspDocMetadata getMetadataInfo(String metadataId) {
        try {
            return this.formDocStorageService.getMetadataInfo(metadataId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 批量下载附件
     * @param metadataIdList 附加id集合
     * @param rootId 根目录
     * @param zipName 压缩包名
     * @return 下载压缩包
     */
    public GspDocContent getMultipleDocCompressedWithName(List<String> metadataIdList, String rootId, String zipName) {
        try {
            return this.formDocStorageService.getMultipleDocCompressedWithName(metadataIdList, rootId, zipName);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //endregion

    //region webapi

    /**
     * <dependency>
     *    <groupId>com.inspur.edp</groupId>
     *    <artifactId>document-storage-api</artifactId>
     *    <version>0.3.2</version>
     * </dependency>
     *
     * 1、对应 interface GspDocService
     *    上传                             post          /api/runtime/dfs/v1.0/doc/
     *    移除                             delete        /api/runtime/dfs/v1.0/doc/
     *    更新                             put           /api/runtime/dfs/v1.0/doc/update
     *    获取附件信息                       get           /api/runtime/dfs/v1.0/doc/fileinfo
     *    下载                              get           /api/runtime/dfs/v1.0/doc/filecontent
     *    批量下载                           get           /api/runtime/dfs/v1.0/doc/multiple/download
     *    批量下载(设置压缩包名)               get           /api/runtime/dfs/v1.0/doc/compress/download/
     *
     *
     * 2、对应 interface GspFormDocService
     *    上传                                post         /api/runtime/dfs/v1.0/formdoc/
     *    移除                                delete       /api/runtime/dfs/v1.0/formdoc/
     *    修改                                put          /api/runtime/dfs/v1.0/formdoc/
     *    批量上传                             post         /api/runtime/dfs/v1.0/formdoc/list
     *    批量移除                             delete       /api/runtime/dfs/v1.0/formdoc/list
     *    获取附件信息                          get          /api/runtime/dfs/v1.0/formdoc/fileinfo
     *    批量获取附件信息                       get          /api/runtime/dfs/v1.0/formdoc/fileinfo/list
     *    下载                                 get          /api/runtime/dfs/v1.0/formdoc/filecontent
     *    批量下载                              get          /api/runtime/dfs/v1.0/formdoc/multiple/download
     *    批量下载(设置压缩包名)                  get           /api/runtime/dfs/v1.0/formdoc/compress/download
     *
     *
     *
     * <dependency>
     *     <groupId>com.inspur.edp</groupId>
     *     <artifactId>document-viewer</artifactId>
     *     <version>0.3.2</version>
     * </dependency>
     *
     * 3、对应 interface GspFileViewerService
     *     单个附件下载地址获取                   get           /api/runtime/dfs/v1.0/fileviewer/file
     *     批量附件下载地址获取                   get           /api/runtime/dfs/v1.0/fileviewer/filelist
     */

    //endregion

}
