package com.example.demo.exception;

public class Constants {
    public static final int DEFAULT_SAF_VERSION = 210;
    public static final int JSF_VERSION = 1691;
    public static final String JSF_BUILD_VERSION = "1.6.9_201905241210";
    public static final byte[] MAGICCODEBYTE = new byte[]{-83, -49};
    public static final int REQUEST_MSG = 1;
    public static final int RESPONSE_MSG = 2;
    public static final int HEARTBEAT_REQUEST_MSG = 10;
    public static final int HEARTBEAT_RESPONSE_MSG = 11;
    public static final int SHAKEHAND_MSG = 6;
    public static final int SHAKEHAND_RESULT_MSG = 7;
    public static final int CALLBACK_REQUEST_MSG = 4;
    public static final int CALLBACK_RESPONSE_MSG = 5;
    public static final int RPCEXCEPTION_INVOKER_MISMATCH = 23006;
    public static final Boolean isWindows = CommonUtils.isWindows();
    public static final Boolean isLinux = CommonUtils.isLinux();
//    public static final int CPU_CORES = CommonUtils.getCpuCores();
    public static final String REGISTRY_PROTOCOL_ZK = "jdZooKeeper";
    public static final String REGISTRY_PROTOCOL_FILE = "fileRegistry";
    public static final String REGISTRY_PROTOCOL_JSF = "jsfRegistry";
    public static final String LOADBALANCE_RANDOM = "random";
    public static final String LOADBALANCE_ROUNDROBIN = "roundrobin";
    public static final String LOADBALANCE_LEASTACTIVE = "leastactive";
    public static final String LOADBALANCE_CONSISTENTHASH = "consistenthash";
    public static final String LOADBALANCE_LOCALPREF = "localpref";
    public static final String CLUSTER_FAILOVER = "failover";
    public static final String CLUSTER_FAILFAST = "failfast";
    public static final String CLUSTER_BROADCAST = "broadcast";
    public static final String CLUSTER_TRANSPORT_PINPOINT = "pinpoint";
    public static final String CLUSTER_TRANSPORT_RESETTABLE = "resettable";
    public static final int DEFAULT_CLIENT_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_CLIENT_DISCONNECT_TIMEOUT = 10000;
    public static final int DEFAULT_CLIENT_INVOKE_TIMEOUT = 5000;
    public static final int DEFAULT_REGISTRY_CONNECT_TIMEOUT = 20000;
    public static final int DEFAULT_RETRIES_TIME = 0;
    public static final String THREADPOOL_TYPE_FIXED = "fixed";
    public static final String THREADPOOL_TYPE_CACHED = "cached";
    public static final String DISPATCHER_ALL = "all";
    public static final String DISPATCHER_DIRECT = "direct";
    public static final String DISPATCHER_MESSAGE = "message";
    public static final String DISPATCHER_EXECUTION = "execution";
    public static final String DISPATCHER_CONNECTION = "connection";
    public static final String QUEUE_TYPE_NORMAL = "normal";
    public static final String QUEUE_TYPE_PRIORITY = "priority";
//    public static final int DEFAULT_IO_THREADS;
    public static final int DEFAULT_SERVER_BIZ_THREADS = 200;
    public static final int DEFAULT_SERVER_QUEUE = 0;
    public static final int DEFAULT_PROVIDER_WEIGHT = 100;
    public static final int DEFAULT_CLIENT_BIZ_THREADS = 20;
    public static final int DEFAULT_CLIENT_CALLBACK_CORE_THREADS = 20;
    public static final int DEFAULT_CLIENT_CALLBACK_MAX_THREADS = 200;
    public static final int DEFAULT_CLIENT_CALLBACK_QUEUE = 256;
    public static final int DEFAULT_CLIENT_CONNECT_MAX_THREADS = 10;
//    public static final Constants.ProtocolType DEFAULT_PROTOCOL_TYPE;
    public static final String DEFAULT_PROTOCOL = "jsf";
//    public static final Constants.CodecType DEFAULT_CODEC_TYPE;
    public static final String DEFAULT_CODEC = "msgpack";
    public static final String PROXY_JDK = "jdk";
    public static final String PROXY_JAVASSIST = "javassist";
//    public static final Charset DEFAULT_CHARSET;
    public static final int DEFAULT_SERVER_PORT = 22000;
    public static final String DEFAULT_SERVER_CONTEXT_PATH = "/";
    public static final int DEFAULT_METHOD_PRIORITY = 0;
    public static final int DEFAULT_PROVIDER_DELAY = -1;
    public static final int DEFAULT_PAYLOAD = 8388608;
    public static final int DEFAULT_BUFFER_SIZE = 8192;
    public static final int WRITE_BUFFER_HIGH_WATER_MARK = 65536;
    public static final int WRITE_BUFFER_LOW_WATER_MARK = 32768;
    public static final int MAX_BUFFER_SIZE = 32768;
    public static final int MIN_BUFFER_SIZE = 1024;
    public static final int DEFAULT_HEARTBEAT_TIME = 30000;
    public static final int DEFAULT_RECONNECT_TIME = 10000;
    public static final int DEFAULT_CANDIDATE_TIME = 60000;
    public static final int DEFAULT_INITIAL_SIZE = -1;
    public static final int DEFAULT_MAX_ACTIVE = -1;
    public static final String CLIENT_CHANNELHANDLE_NAME = "JSF_CLIENT_CHANNELHANDLE";
//    public static final String CLIENT_CHECK_PROVIDER_DELIMITER;
    public static final String CLIENT_CHECK_PROVIDER_NOMAL = "1";
    public static final String CLIENT_CHECK_PROVIDER_EXCEPTION = "0";
    public static final String CHECK_AUTH_OK = "1";
    public static final String CHECK_AUTH_FAIL = "0";
    public static final char INTERNAL_KEY_PREFIX = '_';
    public static final String INTERNAL_KEY_REMOTE = "_remote";
    public static final String INTERNAL_KEY_LOCAL = "_local";
    public static final String INTERNAL_KEY_ELAPSED = "_elapsed";
    public static final String INTERNAL_KEY_RESULT = "_result";
    public static final String INTERNAL_KEY_INPUT = "_input";
    public static final String INTERNAL_KEY_OUTPUT = "_output";
    public static final String INTERNAL_KEY_MONITOR = "_monitor";
    public static final String INTERNAL_KEY_INTERRFACE = "_interface";
    public static final String INTERNAL_KEY_ALIAS = "_alias";
    public static final String INTERNAL_KEY_ONRETURN = "_onreturn";
    public static final String INTERNAL_KEY_PROTOCOL = "_protocol";
    public static final String INTERNAL_KEY_APPID = "_appId";
    public static final String INTERNAL_KEY_APPNAME = "_appName";
    public static final String INTERNAL_KEY_APPINSID = "_appInsId";
    public static final String INTERNAL_KEY_ASYNC = "_async";
    public static final String INTERNAL_KEY_KEEPALIVE = "_keepAlive";
    public static final String INTERNAL_KEY_RETRYTIME = "_retryTime";
    public static final String INTERNAL_KEY_CONSUMERALIAS = "_consumerAlias";
    public static final String INTERNAL_KEY_PROVIDER_LIMIT_TOTAL = "_[total]_";
    public static final char HIDE_KEY_PREFIX = '.';
    public static final String HIDDEN_KEY_TOKEN = ".token";
    public static final String HIDDEN_KEY_MONITOR = ".monitor";
    public static final String HIDDEN_KEY_PINPOINT = ".pinpoint";
    public static final String HIDDEN_KEY_WARNNING = ".warnning";
    public static final String HIDDEN_KEY_DESTROY = ".destroy";
    public static final String HIDDEN_KEY_APPID = ".appId";
    public static final String HIDDEN_KEY_APPNAME = ".appName";
    public static final String HIDDEN_KEY_APPINSID = ".appInsId";
    public static final String HIDDEN_KEY_SESSION = ".session";
    public static final String HIDDEN_KEY_DST_PARAM = ".dstParam";
    public static final String HIDDEN_KEY_DST_JSF_VERSION = ".dstJsfVer";
    public static final String HIDDEN_KEY_DST_LANGUAGE = ".dstLan";
    public static final String HIDDEN_KEY_JST_DATA = ".jstData";
    public static final String HIDDEN_KEY_RETRY_TIME = ".retryTime";
    public static final String HIDDEN_KEY_CONSUMER_ALIAS = ".consumerAlias";
    public static final String CONFIG_KEY_GENERIC = "generic";
    public static final String CONFIG_KEY_ASYNC = "async";
    public static final String CONFIG_KEY_RETRIES = "retries";
    public static final String CONFIG_KEY_TIMEOUT = "timeout";
    public static final String CONFIG_KEY_CONCURRENTS = "concurrents";
    public static final String CONFIG_KEY_PARAMS = "parameters";
    public static final String CONFIG_KEY_ONRETURN = "onreturn";
    public static final String CONFIG_KEY_WEIGHT = "weight";
    public static final String CONFIG_KEY_SAFVERSION = "safVersion";
    public static final String CONFIG_KEY_INTERFACE = "interface";
    public static final String CONFIG_KEY_ALIAS = "alias";
    public static final String CONFIG_KEY_DYNAMIC = "dynamic";
    public static final String CONFIG_KEY_VALIDATION = "validation";
    public static final String CONFIG_KEY_MOCK = "mock";
    public static final String CONFIG_KEY_CACHE = "cache";
    public static final String CONFIG_KEY_COMPRESS = "compress";
    public static final String CONFIG_KEY_PRIORITY = "priority";
    public static final String CONFIG_KEY_JSFVERSION = "jsfVersion";
    public static final String CONFIG_KEY_CROSSLANG = "crossLang";
    public static final String CONFIG_KEY_SERIALIZATION = "serialization";
    public static final String GLOBAL_SETTING = "global_setting";
    public static final String SETTING_REGISTRY_HEARTBEAT_INTERVAL = "reg.hb.interval";
    public static final String SETTING_REGISTRY_CHECK_INTERVAL = "reg.ck.interval";
    public static final String SETTING_REGISTRY_BACKUP_DIR = "reg.bk.dir";
    public static final String SETTING_MONITOR_SEND_INTERVAL = "mntr.send.interval";
    public static final String SETTING_MONITOR_GLOBAL_OPEN = "mntr.send.open";
    public static final String SETTING_SERVER_SUDO_PASSWD = "srv.sudo.passwd";
    public static final String SETTING_SERVER_SUDO_WHITELIST = "srv.sudo.whitelist";
    public static final String SETTING_INVOKE_CP_OPEN = "invoke.compress.open";
    public static final String SETTING_INVOKE_CP_SIZE = "invoke.compress.size";
    public static final String SETTING_JST_OPEN = "jst.open";
    public static final String SETTING_MONITOR_OPEN = "mntr.p.open";
    public static final String SETTING_MONITOR_WHITELIST = "mntr.whitelist";
    public static final String SETTING_MONITOR_ELASPED_METRIC = "mntr.elasped.metric";
    public static final String SETTING_MONITOR_SLICE_INTERVAL = "mntr.slice.interval";
    public static final String SETTING_INVOKE_TOKEN = "invoke.token";
    public static final String SETTING_INVOKE_WB_OPEN = "invoke.wb.open";
    public static final String SETTING_INVOKE_WHITELIST = "invoke.whitelist";
    public static final String SETTING_INVOKE_BLACKLIST = "invoke.blacklist";
    public static final String SETTING_INVOKE_MOCKRESULT = "invoke.mockresult";
    public static final String SETTING_INVOKE_APPLIMIT = "invoke.applimit";
    public static final String SETTING_INVOKE_PROVIDER_LIMIT = "invoke.provider.limit";
    public static final String SETTING_ROUTER_OPEN = "router.open";
    public static final String SETTING_ROUTER_RULE = "router.rule";
    public static final String SETTING_MAP_PARAM_ALIAS = "map.param.alias";
    public static final String SETTING_TRANSPORT_PROVIDER_BATCH = "transport.provider.ringbuffer";
    public static final String SETTING_TRANSPORT_CONSUMER_BATCH = "transport.consumer.ringbuffer";
    public static final String SETTING_CALLBACK_POOL_CORE_SIZE = "callback.pool.coresize";
    public static final String SETTING_CALLBACK_POOL_MAX_SIZE = "callback.pool.maxsize";
    public static final String SETTING_CALLBACK_POOL_QUEUE = "callback.pool.queue";
    public static final String SETTING_SERIALIZE_CHECK_CLASS = "serialize.check.class";
    public static final String SETTING_TRANSPORT_CONSUMER_EPOLL = "transport.consumer.epoll";
    public static final String SETTING_CHECK_SYSTEM_TIME = "check.system.time";
    public static final String SETTING_MONITOR_SEND_URL = "monitor.send.url";
    /** @deprecated */
    @Deprecated
    public static final String SETTING_JSON_SERIALIZE_FILL_EMPTY = "json.serialize.fill.empty";
    public static final String SETTING_JSON_SERIALIZER_FEATURES = "json.serializer.features";
    public static final String SETTING_JSON_PARSER_FEATURES = "json.parser.features";
    public static final String SETTING_CONSUMER_PROVIDER_NULLABLE = "consumer.provider.nullable";
    public static final String SETTING_INVOKE_SEND_APP = "invoke.send.app";
    public static final String SETTING_REGISTRY_REGISTER_BATCH = "registry.register.batch";
    public static final String SETTING_SERIALIZE_CHECK_REFERENCE = "serialize.check.reference";
    public static final String SETTING_HTTP_KEEP_ALIVE = "http.keepAlive";
    public static final String SECURITY_IS_OPEN_PROVIDER = "security.isOpen.provider";
    public static final String SECURITY_TOKEN_SERVER_FILE_URL = "security.token.server.fileUrl";
    public static final String SECURITY_TOKEN_CLIENT_FILE_URL = "security.token.client.fileUrl";
    public static final String SECURITY_PRIKEY_CLIENT_FILE_URL = "security.prikey.client.fileUrl";
    public static final String SECURITY_VERSION = "security_version";

    public Constants() {
    }

//    static {
//        DEFAULT_IO_THREADS = CPU_CORES + 1;
//        DEFAULT_PROTOCOL_TYPE = Constants.ProtocolType.jsf;
//        DEFAULT_CODEC_TYPE = Constants.CodecType.msgpack;
//        DEFAULT_CHARSET = Charset.forName("UTF-8");
//        CLIENT_CHECK_PROVIDER_DELIMITER = new String(new byte[]{31});
//    }

    public static enum CompressType {
        NONE((byte)0),
        lzma((byte)1),
        snappy((byte)2);

        private byte value;

        private CompressType(byte mvalue) {
            this.value = mvalue;
        }

        public byte value() {
            return this.value;
        }

        public static Constants.CompressType valueOf(byte value) {
            Constants.CompressType p;
            switch(value) {
                case 0:
                    p = NONE;
                    break;
                case 1:
                    p = lzma;
                    break;
                case 2:
                    p = snappy;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown compress type value: " + value);
            }

            return p;
        }
    }

    public static enum HeadKey {
        timeout((byte)1, Integer.class),
        callbackInsId((byte)5, String.class),
        jsfVersion((byte)7, Short.class),
        srcLanguage((byte)8, Byte.class),
        responseCode((byte)9, Byte.class),
        checkProvider((byte)10, String.class),
        checkAuth((byte)11, String.class);

        private byte keyNum;
        private Class type;

        private HeadKey(byte b, Class clazz) {
            this.keyNum = b;
            this.type = clazz;
        }

        public byte getNum() {
            return this.keyNum;
        }

        public Class getType() {
            return this.type;
        }

        public static Constants.HeadKey getKey(byte num) {
            Constants.HeadKey key = null;
            switch(num) {
                case 1:
                    key = timeout;
                    break;
                case 2:
                case 3:
                case 4:
                case 6:
                default:
                    throw new IllegalArgumentException("Unknown head key value: " + num);
                case 5:
                    key = callbackInsId;
                    break;
                case 7:
                    key = jsfVersion;
                    break;
                case 8:
                    key = srcLanguage;
                    break;
                case 9:
                    key = responseCode;
                    break;
                case 10:
                    key = checkProvider;
            }

            return key;
        }
    }

    public static enum CodecType {
        /** @deprecated */
        @Deprecated
        dubbo(1),
        hessian(2),
        java(3),
        /** @deprecated */
        @Deprecated
        compactedjava(4),
        json(5),
        /** @deprecated */
        @Deprecated
        fastjson(6),
        /** @deprecated */
        @Deprecated
        nativejava(7),
        /** @deprecated */
        @Deprecated
        kryo(8),
        msgpack(10),
        /** @deprecated */
        @Deprecated
        nativemsgpack(11),
        protobuf(12);

        private int value;

        private CodecType(int mvalue) {
            this.value = mvalue;
        }

        public int value() {
            return this.value;
        }

        public static Constants.CodecType valueOf(int value) {
            Constants.CodecType p;
            switch(value) {
                case 1:
                    p = dubbo;
                    break;
                case 2:
                    p = hessian;
                    break;
                case 3:
                    p = java;
                    break;
                case 4:
                    p = compactedjava;
                    break;
                case 5:
                    p = json;
                    break;
                case 6:
                    p = fastjson;
                    break;
                case 7:
                    p = nativejava;
                    break;
                case 8:
                    p = kryo;
                    break;
                case 9:
                default:
                    throw new IllegalArgumentException("Unknown codec type value: " + value);
                case 10:
                    p = msgpack;
                    break;
                case 11:
                    p = nativemsgpack;
                    break;
                case 12:
                    p = protobuf;
            }

            return p;
        }
    }

    public static enum ProtocolType {
        consumer(0),
        /** @deprecated */
        @Deprecated
        saf(1),
        jsf(1),
        rest(2),
        dubbo(3),
        webservice(4),
        jaxws(5),
        /** @deprecated */
        @Deprecated
        jaxrs(6),
        /** @deprecated */
        @Deprecated
        hessian(7),
        /** @deprecated */
        @Deprecated
        thrift(8),
        http(9);

        private int value;

        private ProtocolType(int mvalue) {
            this.value = mvalue;
        }

        public int value() {
            return this.value;
        }

        public static Constants.ProtocolType valueOf(int value) {
            Constants.ProtocolType p;
            switch(value) {
                case 1:
                    p = jsf;
                    break;
                case 2:
                    p = rest;
                    break;
                case 3:
                    p = dubbo;
                    break;
                case 4:
                    p = webservice;
                    break;
                case 5:
                    p = jaxws;
                    break;
                case 6:
                    p = jaxrs;
                    break;
                case 7:
                    p = hessian;
                    break;
                case 8:
                    p = thrift;
                    break;
                case 9:
                    p = http;
                    break;
                default:
                    throw new IllegalArgumentException("Unknown protocol type value: " + value);
            }

            return p;
        }
    }
}
