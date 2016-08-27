package Utils;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 *  @author Bruno Konzen Stahl
 *  @since 30/11/2010
 *  TODO SOMENTE PARA ARQUIVOS .wav
 */
public class PlayerUtils implements Runnable{

	//Armazena o endere�o do arquivo de audio
	private URL url;
	private Clip clip;

	/**
	 *  TODO Esse m�todo foi criado para permitir o acesso est�tico aos recursos da classe
	 */
	public static void play(URL url){
		new PlayerUtils(url);
	}

	/**
	 *  TODO Construtor da classe PlayerUtils
	 *  Esse m�todo � invocado quando a classe PlayerUtils � instanciada
	 *  Por exemplo: PlayerUtils utlis = new PlayerUtils();
	 */
	public PlayerUtils(URL url){
		this.url = url;
		Thread t = new Thread(this);
		t.setPriority(Thread.MIN_PRIORITY);
		t.start();
	}

	/**
	 *  Essa classe � uma Thread (vai executar em paralelo com a sua aplica��o).
	 *  O m�doto run() � invocado quando a seguinte linha do construtor � executada 't.start()';
	 */
	public void run(){
		try {
			AudioInputStream stream = AudioSystem.getAudioInputStream(url);
			DataLine.Info info = new DataLine.Info(Clip.class, stream.getFormat());
			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void stop(){
		clip.stop();
	}
}