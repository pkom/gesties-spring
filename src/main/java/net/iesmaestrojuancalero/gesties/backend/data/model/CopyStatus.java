package net.iesmaestrojuancalero.gesties.backend.data.model;

public enum CopyStatus {
    BORROWED, AVAILABLE, DEPRECATED;

    public static final String PREFIX = "STATUS_";

    public static CopyStatus of(String withPrefix) {
        return CopyStatus.valueOf(withPrefix.replace(CopyStatus.PREFIX, ""));
    }

    public String withPrefix() {
        return PREFIX + this.toString();
    }

}
