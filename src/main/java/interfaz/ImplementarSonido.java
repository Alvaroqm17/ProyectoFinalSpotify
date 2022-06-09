package interfaz;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public interface ImplementarSonido {

	public default void sonidoPlay(String nombreSonido) {
		try {
			AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido));
			Clip clip = AudioSystem.getClip();
			clip.open(audioInputStream);
			clip.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
			ex.printStackTrace();
		}
	}

}
