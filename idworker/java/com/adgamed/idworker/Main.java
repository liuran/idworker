package com.adgamed.idworker;


import org.eclipse.jetty.server.NetworkTrafficServerConnector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * Created by liuran on 2017/10/22.
 */
public class Main {

    public static void main(String[] args) throws Exception{
        Server server = new Server();
        NetworkTrafficServerConnector connector = new NetworkTrafficServerConnector(server);
        int port = Integer.parseInt(System.getProperty("port", "18001"));
        connector.setPort(port);
        server.addConnector(connector);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new IdWorkerServlet()), "/*");
        server.setHandler(context);

        server.start();
        server.join();
    }
}
