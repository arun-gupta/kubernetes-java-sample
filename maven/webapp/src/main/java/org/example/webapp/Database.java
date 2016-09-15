package org.example.webapp;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.CouchbaseCluster;
import java.util.concurrent.TimeUnit;

/**
 * @author arungupta
 */
public class Database {

    static CouchbaseCluster cluster;
    static Bucket bucket;

    public static final CouchbaseCluster getCluster() {
        if (null == cluster) {
            System.out.println(System.getenv());
            String host = System.getenv("DB_URI");
            if (null == host) {
                host = "localhost";
                System.out.println("Invalid host, setting to " + host);
            }
            System.out.println("Using host: " + host);
            cluster = CouchbaseCluster.create(host);
        }
        return cluster;
    }

    public static Bucket getBucket(String bucketName) {
        if (null == bucket) {
            bucket = getCluster().openBucket(bucketName, 30, TimeUnit.SECONDS);
        }
        return bucket;
    }
}
