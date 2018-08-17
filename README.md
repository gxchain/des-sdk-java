# des-sdk
data exchange service sdk

# Install
dependency setting：
```
Added to the pom.xml
<dependency>
    <groupId>com.gxb.des</groupId>
    <artifactId>des-sdk</artifactId>
    <version>1.0.4-RELEASE</version>
</dependency>

then add a repository to pom.xml
<repositories>
    <repository>
        <id>gxchain</id>
        <url>http://repo.gxchain.cn/repository/maven-public/</url>
    </repository>
<repositories>
```
# Usage
### merchant
```
//1、initializing
MerchantClient client = new MerchantClient(MERCHANT_PRIVATEKEY, MERCHANT_ACCOUNT, DES_SERVER_URL);

//2、data exchange
JSONObject param = doParam();
//create a trade request to obtain request id
String requestId = client.createDataExchangeRequest(productId, param);
//get the data results by request id
DataExchangeDto result = client.getResult(requestId);
```
### datasource
```
//1、initializing
DatasourceClient client = new DatasourceClient(DATASOURCE_PRIVATEKEY, DATASOURCE_ACCOUNT, DES_SERVER_URL);
//start the heartbeat thread
ScheduledExecutorService es = Executors.newScheduledThreadPool(1);
es.scheduleAtFixedRate(() -> {
    try {
        client.heartbeat(Arrays.asList(1));
    } catch (Exception e) {
        log.error(e.getMessage(), e);
    }
}, 5, 30, TimeUnit.SECONDS);


//2、query api
@RequestMapping(value = "/query", method = RequestMethod.POST)
public Object queryData(@RequestBody DataRequestParam requestParam) {
    //decrypt param
    JSONObject param = client.decrypt(requestParam);
    //query data
    ResponseObject data = queryData(param);
    //encrypt data
    return client.encrypt(data,requestParam);
}
```

# Dev Document
https://doc.gxb.io/des/