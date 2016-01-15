package com.github.s4ke.silentgreen;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Martin on 14.01.2016.
 */
public class Main {

	public static void main(String[] args)
			throws IOException, UnsupportedAudioFileException, LineUnavailableException, InterruptedException {
		System.out.println( "Playing sound of Silence! (C) Martin Braun 2016" );
		Clip clip = AudioSystem.getClip();
		try (InputStream is = Main.class.getResourceAsStream( "/silent.wav" );
			 BufferedInputStream bis = new BufferedInputStream( is )) {
			AudioInputStream inputStream = AudioSystem.getAudioInputStream(
					bis
			);
			clip.open( inputStream );
			while ( true ) {
				System.out.println( "beep." );
				clip.start();
				Thread.sleep( 1000 * 60 );
			}
		}
		finally {
			if ( clip != null ) {
				clip.close();
			}
		}
	}

}
