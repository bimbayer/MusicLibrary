package de.creative.musiclib.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Block {
	private final StringProperty blockName;
	private final StringProperty song1;
	private final StringProperty song2;
	private final StringProperty song3;
	private final StringProperty song4;
	private final StringProperty song5;
	private final StringProperty song6;
	
	private final StringProperty song1transition;
	private final StringProperty song2transition;
	private final StringProperty song3transition;
	private final StringProperty song4transition;
	private final StringProperty song5transition;
	private final StringProperty song6transition;

	public Block() {
		this("Default", "", "", "", "", "", "", "", "", "", "", "", "");
	}

	public Block(String pBlockName, String pSong1, String pSong2, String pSong3, String pSong4, String pSong5,
			String pSong6, String pSong1transition, String pSong2transition, String pSong3transition, String pSong4transition, String pSong5transition,
			String pSong6transition) {
		this.blockName = new SimpleStringProperty(pBlockName);
		this.song1 = new SimpleStringProperty(pSong1);
		this.song2 = new SimpleStringProperty(pSong2);
		this.song3 = new SimpleStringProperty(pSong3);
		this.song4 = new SimpleStringProperty(pSong4);
		this.song5 = new SimpleStringProperty(pSong5);
		this.song6 = new SimpleStringProperty(pSong6);
		
		this.song1transition = new SimpleStringProperty(pSong1transition);
		this.song2transition = new SimpleStringProperty(pSong2transition);
		this.song3transition = new SimpleStringProperty(pSong3transition);
		this.song4transition = new SimpleStringProperty(pSong4transition);
		this.song5transition = new SimpleStringProperty(pSong5transition);
		this.song6transition = new SimpleStringProperty(pSong6transition);
	}

	public String getBlockName() {
		return blockName.get();
	}

	public void setBlockName(String pblockName) {
		this.blockName.set(pblockName);
	}

	public StringProperty blockNameProperty() {
		return blockName;
	}

	public String getSong1() {
		return song1.get();
	}

	public void setSong1(String pSong) {
		this.song1.set(pSong);
	}

	public StringProperty song1Property() {
		return song1;
	}

	public String getSong2() {
		return song2.get();
	}

	public void setSong2(String pSong) {
		this.song2.set(pSong);
	}

	public StringProperty song2Property() {
		return song2;
	}

	public String getSong3() {
		return song3.get();
	}

	public void setSong3(String pSong) {
		this.song3.set(pSong);
	}

	public StringProperty song3Property() {
		return song3;
	}

	public String getSong4() {
		return song4.get();
	}

	public void setSong4(String pSong) {
		this.song4.set(pSong);
	}

	public StringProperty song4Property() {
		return song4;
	}

	public String getSong5() {
		return song5.get();
	}

	public void setSong5(String pSong) {
		this.song5.set(pSong);
	}

	public StringProperty song5Property() {
		return song5;
	}

	public String getSong6() {
		return song6.get();
	}

	public void setSong6(String pSong) {
		this.song6.set(pSong);
	}

	public StringProperty song6Property() {
		return song6;
	}

	
	public String getSong1transition() {
		return song1transition.get();
	}

	public void setSong1transition(String pSongtransition) {
		this.song1transition.set(pSongtransition);
	}

	public StringProperty song1transitionProperty() {
		return song1transition;
	}

	public String getSong2transition() {
		return song2transition.get();
	}

	public void setSong2transition(String pSongtransition) {
		this.song2transition.set(pSongtransition);
	}

	public StringProperty song2transitionProperty() {
		return song2transition;
	}

	public String getSong3transition() {
		return song3transition.get();
	}

	public void setSong3transition(String pSongtransition) {
		this.song3transition.set(pSongtransition);
	}

	public StringProperty song3transitionProperty() {
		return song3transition;
	}

	public String getSong4transition() {
		return song4transition.get();
	}

	public void setSong4transition(String pSongtransition) {
		this.song4transition.set(pSongtransition);
	}

	public StringProperty song4transitionProperty() {
		return song4transition;
	}

	public String getSong5transition() {
		return song5transition.get();
	}

	public void setSong5transition(String pSongtransition) {
		this.song5transition.set(pSongtransition);
	}

	public StringProperty song5transitionProperty() {
		return song5transition;
	}

	public String getSong6transition() {
		return song6transition.get();
	}

	public void setSong6transition(String pSongtransition) {
		this.song6transition.set(pSongtransition);
	}

	public StringProperty song6transitionProperty() {
		return song6transition;
	}
}
