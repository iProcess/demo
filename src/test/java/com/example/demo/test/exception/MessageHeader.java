package com.example.demo.test.exception;


import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class MessageHeader implements Cloneable {
    private Integer length;
    private Short headerLength;
    private int protocolType;
    private int codecType;
    private int msgType;
    private int msgId;
    private byte compressType;
    private Map<Byte, Object> keysMap;

    public MessageHeader() {
//        this.protocolType = Constants.DEFAULT_PROTOCOL_TYPE.value();
//        this.codecType = Constants.DEFAULT_CODEC_TYPE.value();
//        this.compressType = Constants.CompressType.NONE.value();
        this.keysMap = new ConcurrentHashMap();
    }

    public Map<Byte, Object> getAttrMap() {
        return this.keysMap;
    }

    public MessageHeader setValues(int protocolType, int codecType, int msgType, int compressType, int msgId) {
        this.msgId = msgId;
        this.codecType = codecType;
        this.msgType = msgType;
        this.protocolType = protocolType;
        this.compressType = (byte)compressType;
        return this;
    }

    public MessageHeader copyHeader(MessageHeader header) {
        this.msgId = header.msgId;
        this.codecType = header.codecType;
        this.msgType = header.msgType;
        this.protocolType = header.getProtocolType();
        this.compressType = header.getCompressType();
        this.length = header.getLength();
        this.headerLength = header.getHeaderLength();
        Map<Byte, Object> tempMap = header.getAttrMap();
        Iterator i$ = tempMap.entrySet().iterator();

        while(i$.hasNext()) {
            Entry<Byte, Object> entry = (Entry)i$.next();
            this.keysMap.put(entry.getKey(), entry.getValue());
        }

        return this;
    }

    public Short getHeaderLength() {
        return this.headerLength;
    }

    public void setHeaderLength(Short headerLength) {
        this.headerLength = headerLength;
    }

    public int getMsgId() {
        return this.msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public Integer getLength() {
        return this.length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public int getCodecType() {
        return this.codecType;
    }

    public void setCodecType(int codecType) {
        this.codecType = codecType;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public byte getCompressType() {
        return this.compressType;
    }

    public void setCompressType(byte compressType) {
        this.compressType = compressType;
    }

    public int getProtocolType() {
        return this.protocolType;
    }

    public void setProtocolType(int protocolType) {
        this.protocolType = protocolType;
    }

    public void setValuesInKeyMap(Map<Byte, Object> valueMap) {
        this.keysMap.putAll(valueMap);
    }

    public int getAttrMapSize() {
        int mapSize = this.keysMap.size();
        return mapSize;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof MessageHeader)) {
            return false;
        } else {
            MessageHeader that = (MessageHeader)o;
            if (this.codecType != that.codecType) {
                return false;
            } else {
                if (this.headerLength != null) {
                    if (!this.headerLength.equals(that.headerLength)) {
                        return false;
                    }
                } else if (that.headerLength != null) {
                    return false;
                }

                if (this.msgId != that.msgId) {
                    return false;
                } else if (this.msgType != that.msgType) {
                    return false;
                } else if (this.protocolType != that.protocolType) {
                    return false;
                } else if (this.compressType != that.compressType) {
                    return false;
                } else {
                    if (this.length != null) {
                        if (!this.length.equals(that.length)) {
                            return false;
                        }
                    } else if (that.length != null) {
                        return false;
                    }

                    return true;
                }
            }
        }
    }

    public int hashCode() {
        int result = this.msgId;
        result = 31 * result + (this.length != null ? this.length.hashCode() : 0);
        result = 31 * result + this.codecType;
        result = 31 * result + this.msgType;
        result = 31 * result + this.protocolType;
        result = 31 * result + this.compressType;
        result = 31 * result + (this.headerLength != null ? this.headerLength.hashCode() : 0);
        return result;
    }

    public String toString() {
        String keymapStr = "";

        Entry entry;
        for(Iterator i$ = this.keysMap.entrySet().iterator(); i$.hasNext(); keymapStr = keymapStr + " " + ((Byte)entry.getKey()).toString() + " : " + entry.getValue().toString()) {
            entry = (Entry)i$.next();
        }

        return "MessageHeader{msgId=" + this.msgId + ", length=" + this.length + ", codecType=" + this.codecType + ", msgType=" + this.msgType + ", protocolType=" + this.protocolType + ", compressType=" + this.compressType + ", headerLength=" + this.headerLength + ", keysMap=" + keymapStr + "}";
    }

    public MessageHeader clone() {
        MessageHeader header = null;

        try {
            header = (MessageHeader)super.clone();
        } catch (CloneNotSupportedException var3) {
            header = new MessageHeader();
            header.copyHeader(this);
        }

        return header;
    }
}
