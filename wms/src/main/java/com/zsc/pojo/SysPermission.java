package com.zsc.pojo;

public class SysPermission {
    private Integer id;

    private String name;

    private String type;

    private String url;

    private String percode;

    private Integer pId;

    private String pids;

    private String sortstr;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode == null ? null : percode.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids == null ? null : pids.trim();
    }

    public String getSortstr() {
        return sortstr;
    }

    public void setSortstr(String sortstr) {
        this.sortstr = sortstr == null ? null : sortstr.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

	@Override
	public String toString() {
		return "SysPermission [id=" + id + ", name=" + name + ", type=" + type + ", url=" + url + ", percode=" + percode
				+ ", pId=" + pId + ", pids=" + pids + ", sortstr=" + sortstr + ", status=" + status + "]";
	}
    
}