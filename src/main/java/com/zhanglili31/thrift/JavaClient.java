package com.zhanglili31.thrift;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;

public class JavaClient {

    public static void main(String[] args) throws TException {
        TTransport transport=new TSocket("localhost",9099);
        transport.open();
        TProtocol protocol = new  TBinaryProtocol(transport);
        Calculator.Client client = new Calculator.Client(protocol);

        client.ping();
        int result=client.add(3, 2);
        System.out.println("计算结果："+result);

        transport.close();
    }
}