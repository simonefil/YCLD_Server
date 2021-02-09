package Templates;

import Templates.AudioFormat;
import Templates.BitDepth;
import Templates.SampleRate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Configuration {

    @JacksonXmlProperty(localName = "SampleRate")
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<SampleRate> sampleRates;

    @JacksonXmlProperty(localName = "AudioFormat")
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<AudioFormat> audioFormats;

    @JacksonXmlProperty(localName = "BitDepth")
    @JacksonXmlCData
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<BitDepth> bitDepths;

    public Configuration() {
    }

    public List<SampleRate> getSampleRates() {
        return sampleRates;
    }

    public void setSampleRates(List<SampleRate> sampleRates) {
        this.sampleRates = sampleRates;
    }

    public List<AudioFormat> getAudioFormats() {
        return audioFormats;
    }

    public void setAudioFormats(List<AudioFormat> audioFormats) {
        this.audioFormats = audioFormats;
    }

    public List<BitDepth> getBitDepths() {
        return bitDepths;
    }

    public void setBitDepths(List<BitDepth> bitDepths) {
        this.bitDepths = bitDepths;
    }
}
