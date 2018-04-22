package com.template.provider.admin.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 系统文件信息表
 *
 * @author ZhouRunBin
 * @email 1875222156@qq.com
 * @date 2018-04-22 19:48:48
 */
@Table(name = "sys_file_info")
public class FileInfo implements Serializable{
private static final long serialVersionUID=1L;

        //
    @Id
    private Integer id;
    
        //系统生成的一个文件标识编号
    @Column(name = "file_id")
    private String fileId;
    
        //文件物理名称
    @Column(name = "physics_name")
    private String physicsName;
    
        //文件物理存储路径
    @Column(name = "physics_route")
    private String physicsRoute;
    
        //文件相对路径
    @Column(name = "relative_path")
    private String relativePath;
    
        //文件大小
    @Column(name = "file_size")
    private Double fileSize;
    
        //创建时间
    @Column(name = "create_time")
    private Date createTime;
    
        //文件类型
    @Column(name = "file_type")
    private String fileType;
    
        //创建人
    @Column(name = "upload_user")
    private Long uploadUser;
    
        //标准MIMETYPE
    @Column(name = "mime_type")
    private String mimeType;
    
        //扩展名
    @Column(name = "extend_name")
    private String extendName;
    
        //封面文件对于流媒体有
    @Column(name = "face_file")
    private String faceFile;
    
        //水印文件图片和PDF目前才有
    @Column(name = "water_make_file")
    private String waterMakeFile;
    
        //64x64图片
    @Column(name = "file64")
    private String file64;
    
        //128x128的图片
    @Column(name = "file128")
    private String file128;
    
        //256x256图片
    @Column(name = "file256")
    private String file256;
    
        //512x512图片
    @Column(name = "file512")
    private String file512;
    

    /**
     * 设置：
     */
    public void setId(Integer id) {
            this.id = id;
    }
    /**
     * 获取：
     */
    public Integer getId() {
            return id;
    }
    /**
     * 设置：系统生成的一个文件标识编号
     */
    public void setFileId(String fileId) {
            this.fileId = fileId;
    }
    /**
     * 获取：系统生成的一个文件标识编号
     */
    public String getFileId() {
            return fileId;
    }
    /**
     * 设置：文件物理名称
     */
    public void setPhysicsName(String physicsName) {
            this.physicsName = physicsName;
    }
    /**
     * 获取：文件物理名称
     */
    public String getPhysicsName() {
            return physicsName;
    }
    /**
     * 设置：文件物理存储路径
     */
    public void setPhysicsRoute(String physicsRoute) {
            this.physicsRoute = physicsRoute;
    }
    /**
     * 获取：文件物理存储路径
     */
    public String getPhysicsRoute() {
            return physicsRoute;
    }
    /**
     * 设置：文件相对路径
     */
    public void setRelativePath(String relativePath) {
            this.relativePath = relativePath;
    }
    /**
     * 获取：文件相对路径
     */
    public String getRelativePath() {
            return relativePath;
    }
    /**
     * 设置：文件大小
     */
    public void setFileSize(Double fileSize) {
            this.fileSize = fileSize;
    }
    /**
     * 获取：文件大小
     */
    public Double getFileSize() {
            return fileSize;
    }
    /**
     * 设置：创建时间
     */
    public void setCreateTime(Date createTime) {
            this.createTime = createTime;
    }
    /**
     * 获取：创建时间
     */
    public Date getCreateTime() {
            return createTime;
    }
    /**
     * 设置：文件类型
     */
    public void setFileType(String fileType) {
            this.fileType = fileType;
    }
    /**
     * 获取：文件类型
     */
    public String getFileType() {
            return fileType;
    }
    /**
     * 设置：创建人
     */
    public void setUploadUser(Long uploadUser) {
            this.uploadUser = uploadUser;
    }
    /**
     * 获取：创建人
     */
    public Long getUploadUser() {
            return uploadUser;
    }
    /**
     * 设置：标准MIMETYPE
     */
    public void setMimeType(String mimeType) {
            this.mimeType = mimeType;
    }
    /**
     * 获取：标准MIMETYPE
     */
    public String getMimeType() {
            return mimeType;
    }
    /**
     * 设置：扩展名
     */
    public void setExtendName(String extendName) {
            this.extendName = extendName;
    }
    /**
     * 获取：扩展名
     */
    public String getExtendName() {
            return extendName;
    }
    /**
     * 设置：封面文件对于流媒体有
     */
    public void setFaceFile(String faceFile) {
            this.faceFile = faceFile;
    }
    /**
     * 获取：封面文件对于流媒体有
     */
    public String getFaceFile() {
            return faceFile;
    }
    /**
     * 设置：水印文件图片和PDF目前才有
     */
    public void setWaterMakeFile(String waterMakeFile) {
            this.waterMakeFile = waterMakeFile;
    }
    /**
     * 获取：水印文件图片和PDF目前才有
     */
    public String getWaterMakeFile() {
            return waterMakeFile;
    }
    /**
     * 设置：64x64图片
     */
    public void setFile64(String file64) {
            this.file64 = file64;
    }
    /**
     * 获取：64x64图片
     */
    public String getFile64() {
            return file64;
    }
    /**
     * 设置：128x128的图片
     */
    public void setFile128(String file128) {
            this.file128 = file128;
    }
    /**
     * 获取：128x128的图片
     */
    public String getFile128() {
            return file128;
    }
    /**
     * 设置：256x256图片
     */
    public void setFile256(String file256) {
            this.file256 = file256;
    }
    /**
     * 获取：256x256图片
     */
    public String getFile256() {
            return file256;
    }
    /**
     * 设置：512x512图片
     */
    public void setFile512(String file512) {
            this.file512 = file512;
    }
    /**
     * 获取：512x512图片
     */
    public String getFile512() {
            return file512;
    }
}