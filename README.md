# Mopidy-Java
<sup>Based on [danbrough/mopidy-java](https://github.com/danbrough/mopidy-java) </sup>

A pure Java library for accessing a Mopidy music server.

## Very basic example
```
    MopidyClient mopidyClient = new MopidyClient("192.168.1.123", 6680);
    mopidyClient.connectBlocking();

    new Core(mopidyClient).getMixer().getVolume().call(new ResponseHandler<Integer>() {
        @Override
        public void onResponse(Integer volume) {
            System.out.println("The current volume is: " + volume);
        }
    });
```

## To-Do's
- Remove RuntimeTypeAdapterFactory and GsonBuilder in Api.java
- Finish implementations of Mopidy objects (e.g. Playlist, Tracklist)
- Update and create new tests
- Create examples
- Refactoring (including code formatting) 
- Maven Central upload + GitHub Badge via shields.io
- GitHub Workflow
