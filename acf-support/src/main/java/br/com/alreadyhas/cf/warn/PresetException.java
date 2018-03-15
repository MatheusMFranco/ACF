package br.com.alreadyhas.cf.warn;

import org.apache.log4j.Logger;

import br.com.alreadyhas.cf.preset.contract.Preset;

public class PresetException extends Exception {

	private static final long serialVersionUID = -4222619945286046874L;
	private static final Logger logger = Logger.getLogger(PresetException.class);

	public PresetException(Class<? extends Preset> preset, Integer id) {
		logger.error(String.format("The %d is not included in the enum %s.", id, preset.getSimpleName()));
	}

	private static void print(PresetException e, String message){
		logger.error(message);
		e.printStackTrace();
	}

	public static void printSetMethod(PresetException e, Class<?> classError, String message, Integer id){
		print(e, String.format("%s.set%s(%d):void", classError.getSimpleName(), message, id));
	}

}
