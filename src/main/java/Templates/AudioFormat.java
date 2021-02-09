package Templates;

public class AudioFormat {
    private String name;
    private String extension;
    private String type;
    private int maxSampleRate;
    private int maxBitDepth;
    private boolean input;
    private boolean output;

    public AudioFormat() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxSampleRate() {
        return maxSampleRate;
    }

    public void setMaxSampleRate(int maxSampleRate) {
        this.maxSampleRate = maxSampleRate;
    }

    public int getMaxBitDepth() {
        return maxBitDepth;
    }

    public void setMaxBitDepth(int maxBitDepth) {
        this.maxBitDepth = maxBitDepth;
    }

    public boolean isInput() {
        return input;
    }

    public void setInput(boolean input) {
        this.input = input;
    }

    public boolean isOutput() {
        return output;
    }

    public void setOutput(boolean output) {
        this.output = output;
    }
}
