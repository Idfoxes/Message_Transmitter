package com.Idfoxes.Adapter.service;

import com.Idfoxes.Adapter.feign.ServiceAClient;
import com.Idfoxes.Adapter.feign.ServiceBClient;
import com.Idfoxes.Adapter.feign.WeatherServiceClient;
import com.Idfoxes.Adapter.model.MsgA;
import com.Idfoxes.Adapter.model.MsgB;
import org.springframework.stereotype.Service;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class MessageAdapterService {
    private final ServiceAClient serviceAClient;
    private final ServiceBClient serviceBClient;
    private final WeatherServiceClient weatherServiceClient;

    public MessageAdapterService(ServiceAClient serviceAClient, ServiceBClient serviceBClient, WeatherServiceClient weatherServiceClient) {
        this.serviceAClient = serviceAClient;
        this.serviceBClient = serviceBClient;
        this.weatherServiceClient = weatherServiceClient;
    }

    public void processMessage() {
        MsgA msgA = serviceAClient.getMessage();

        if (msgA.getMsg() == null || msgA.getMsg().isEmpty()) {
            throw new RuntimeException("Empty message from Service A");
        }

        if (!"ru".equals(msgA.getLng())) {
            return;
        }

        var weather = weatherServiceClient.getWeather(
                msgA.getCoordinates().getLatitude(),
                msgA.getCoordinates().getLongitude()
        );

        MsgB msgB = new MsgB();
        msgB.setTxt(msgA.getMsg());
        msgB.setCreated(ZonedDateTime.now().format(DateTimeFormatter.ISO_INSTANT));
        msgB.setCurrentTemperature(weather.getTemperature());

        serviceBClient.sendMessage(msgB);
    }
}