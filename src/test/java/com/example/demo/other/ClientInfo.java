package com.example.demo.other;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 调用方客户端信息
 */
@SuppressWarnings({"serial"})
public final class ClientInfo implements Serializable {

    /**
     * 调用流水号,调用异常时会返回,必填
     */
    private String uuid = UUID.randomUUID().toString();

    /**
     * 调用方IP,必填
     */
    private String ip;
    /**
     * 调用方机器名
     */
    private String hostName;

    /**
     * 调用方实例路径
     */
    private String instanceHome;

    /**
     * 调用方在自动部署中的AppId
     */
    private String appId;


    /**
     * 调用方名称,请填写自动部署中的AppId
     */
    @NotEmpty(message = "{clientInfo.name.must.not.be.empty}")
    private String name;


    /**
     * 如果调用方本身是一个代理（比如jos），这里应该传入真正调用来源的ip地址
     */
    private String sourceIp;

    /**
     * 用户标识，不同的调用者，可能传入的标识含义不一样
     * 对于网站端：当前登录的京东用户账号
     * 对于shop端：当前登录的商家账号，或其子账号
     * 对于man端：当前登录的erp账号
     * 对于jos：调用接口的app名称
     * 其他应用,请填写应用名称
     */
    @NotEmpty(message = "{clientInfo.userAgent.must.not.be.empty}")
    private String userAgent;

    /**
     * 扩展头信息
     * 当客户端还需要额外传输其他数据到服务端时，可以使用此扩展
     */
    private Map<String, String> heads = new HashMap<String, String>();

    /**
     */
    private String sourceIpPort;
    /**
     * 这个不能public，会存在反序列化问题
     * 有问题可以咨询yanghua.yi
     */
    private ClientInfo(){
        super();
    }

    /**
     * 用于手工指定 appId 和 userAgent
     * @param name 应用在自动部署系统里的id,用于调用授权
     * @param userAgent 用户标识，不同的调用者，可能传入的标识含义不一样
     */
    public ClientInfo(String name, String userAgent) {
        this.name = name;
        this.userAgent = userAgent;
        autoData();
    }

    public ClientInfo(String name, String sourceIp, String userAgent) {
        this.name = name;
        this.sourceIp = sourceIp;
        this.userAgent = userAgent;
        autoData();
    }

    public ClientInfo(String name,String userAgent,String sourceIp,String sourceIpPort) {
        this.name = name;
        this.userAgent = userAgent;
        this.sourceIp = sourceIp;
        this.sourceIpPort = sourceIpPort;
        autoData();
    }

    private void autoData(){
        try {
            ip = getLocalIp();
            hostName = getLocalHostName();
            appId = System.getProperty("deploy.app.id");
            instanceHome = System.getProperty("catalina.base");
            if (instanceHome == null || instanceHome.isEmpty()) {
                instanceHome = System.getProperty("user.dir");
            }
            if(userAgent == null ||  "".equals(userAgent.trim())) {
                userAgent = System.getProperty("deploy.app.name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加头信息
     *
     * @param name  头信息名称
     * @param value 头信息值
     */
    public void addHead(String name, String value) {
        this.heads.put(name, value);
    }

    /**
     * 获取某一个指定的头信息
     *
     * @param name 头信息名称
     * @return 指定的头信息的值
     */
    public String getHead(String name) {
        return this.heads.get(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getHostName() {
        return hostName;
    }

    public void setInstanceHome(String instanceHome) {
        this.instanceHome = instanceHome;
    }

    public String getInstanceHome() {
        return instanceHome;
    }

    public void setSourceIp(String sourceIp) {
        this.sourceIp = sourceIp;
    }

    public String getSourceIp() {
        return sourceIp;
    }

    public void setHeads(Map<String, String> heads) {
        this.heads = heads;
    }

    public Map<String, String> getHeads() {
        return heads;
    }

    public String getSourceIpPort() {
        return sourceIpPort;
    }

    public void setSourceIpPort(String sourceIpPort) {
        this.sourceIpPort = sourceIpPort;
    }

    /**
     * 客户端不要调用此方法,如果调用后果自负.
     * @param appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppId() {
        if(appId==null || "".equals(appId)){
            return name;
        }
        return appId;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    private static String getLocalHostName() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getUuid() {
        return uuid;
    }

    private static final Pattern IP_PATTERN = Pattern.compile("\\d{1,3}(\\.\\d{1,3}){3,5}$");

    /**
     * 获取本机有效的外部IP地址，而非内部的回环IP
     *
     */
    private static String getLocalIp() {
        InetAddress address = getLocalAddress();

        if (address == null) {
            return null;
        }

        String ip = address.getHostAddress();
        if (ip == null
                || "".equals(ip.trim())
                || "0.0.0.0".equals(ip)
                || "127.0.0.1".equals(ip)) {
            ip = address.getHostName();
        }

        return ip;
    }

    private static InetAddress getLocalAddress() {
        InetAddress localAddress = null;
        try {
            //如果能直接取到正确IP就返回，通常windows下可以
            localAddress = InetAddress.getLocalHost();
            if (isValidAddress(localAddress)) {
                return localAddress;
            }
        } catch (Throwable e) {
//            e.printStackTrace();
        }

        try {
            //通过轮询网卡接口来获取IP
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            if (interfaces != null)
                while (interfaces.hasMoreElements())
                    try {
                        NetworkInterface network = interfaces.nextElement();
                        Enumeration<InetAddress> addresses = network.getInetAddresses();
                        if (addresses != null) {
                            while (addresses.hasMoreElements()) {
                                try {
                                    InetAddress address = addresses.nextElement();
                                    if (isValidAddress(address)) {
                                        return address;
                                    }
                                } catch (Throwable e) {
//                                    e.printStackTrace();
                                }
                            }
                        }
                    } catch (Throwable e) {
//                        e.printStackTrace();
                    }
        } catch (Throwable e) {
//            e.printStackTrace();
        }

        return localAddress;
    }

    /**
     * 判断是否为有效合法的外部IP，而非内部回环IP
     *
     * @param address
     */
    private static boolean isValidAddress(InetAddress address) {
        if ((address == null) || (address.isLoopbackAddress())) {
            return false;
        }

        String ip = address.getHostAddress();

        return (ip != null) && (!"0.0.0.0".equals(ip)) && (!"127.0.0.1".equals(ip)) && (IP_PATTERN.matcher(ip).matches());
    }


    public static void main(String[] args) {
        System.out.println(ClientInfo.getLocalIp());
    }

}
