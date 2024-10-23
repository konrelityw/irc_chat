package org.example;

public class ChannelMetaData {
    private String channelName;
    private String topic;
    private int numUsers;

    public ChannelMetaData(String channelName, String topic, int numUsers) {
        this.channelName = channelName;
        this.topic = topic;
        this.numUsers = numUsers;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getNumUsers() {
        return numUsers;
    }

    public void setNumUsers(int numUsers) {
        this.numUsers = numUsers;
    }
}
