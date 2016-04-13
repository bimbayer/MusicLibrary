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

	public Block() {
		this("Default", "", "", "", "", "", "");
	}

	public Block(String pBlockName, String pSong1, String pSong2, String pSong3, String pSong4, String pSong5,
			String pSong6) {
		this.blockName = new SimpleStringProperty(pBlockName);
		this.song1 = new SimpleStringProperty(pSong1);
		this.song2 = new SimpleStringProperty(pSong2);
		this.song3 = new SimpleStringProperty(pSong3);
		this.song4 = new SimpleStringProperty(pSong4);
		this.song5 = new SimpleStringProperty(pSong5);
		this.song6 = new SimpleStringProperty(pSong6);
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

}
