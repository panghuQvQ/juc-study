package com.tuling.designpattern.study;


/**
 * @author admin
 * @version 1.0.0
 * @ClassName AbstractFactory.java
 * @Description TODO 抽象工厂模式
 *      举例：连接数据库 分为 Mysql, Oracle...
 *               行为  分为 connection, command
 * @createTime 2023年02月14日 15:29:00
 */
public class AbstractFactory {

    public static void main(String[] args) {

//        IDatabaseUtilsFactory factory = new MysqlDatabaseUtils();
        IDatabaseUtilsFactory factory = new OracleDatabaseUtils();
        IConnection connection = factory.getConnection();
        connection.connect();
        ICommand command = factory.getCommand();
        command.command();
    }


}

// 抽象接口
interface IConnection{
    void connect();
}

// 接口实现
class MysqlConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("mysql connected...");
    }
}

class OracleConnection implements IConnection{

    @Override
    public void connect() {
        System.out.println("oracle connected...");
    }
}

interface ICommand{
    void command();
}
class MysqlCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("mysql command...");
    }
}
class OracleCommand implements ICommand{

    @Override
    public void command() {
        System.out.println("oracle command...");
    }
}


// 抽象工厂
interface IDatabaseUtilsFactory{
    IConnection getConnection();
    ICommand getCommand();
}


// 具体工厂
class MysqlDatabaseUtils implements IDatabaseUtilsFactory{

    @Override
    public IConnection getConnection() {
        return new MysqlConnection();
    }

    @Override
    public ICommand getCommand() {
        return new MysqlCommand();
    }
}

// 具体工厂
class OracleDatabaseUtils implements IDatabaseUtilsFactory{

    @Override
    public IConnection getConnection() {
        return new OracleConnection();
    }

    @Override
    public ICommand getCommand() {
        return new OracleCommand();
    }
}


