public class ComplexDependency {

    private NetworkManager networkManager;
    //more fields

    public ComplexDependency(NetworkManager networkManager) {
        this.networkManager = networkManager;
    }

    public String getInfo() {
        return "ComplexDependency is " + networkManager.getUrl() + ":" + networkManager.getPort();
    }

    //do some actions
}