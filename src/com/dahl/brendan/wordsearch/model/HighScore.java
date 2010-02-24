//    This file is part of WordSearch FREE.
//
//    WordSearch FREE is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation, either version 3 of the License, or
//    (at your option) any later version.
//
//    WordSearch FREE is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with WordSearch FREE.  If not, see <http://www.gnu.org/licenses/>.
//
//	  Copyright 2009-2010 Brendan Dahl

package com.dahl.brendan.wordsearch.model;

/**
 * 
 * @author Brendan Dahl
 *
 * this class holds a single high score and can be used to compare one high score to another based on the score attribute
 */
public class HighScore implements Comparable<HighScore> {
	final private static int SCORE_MAX = 1000000;
	private String initials;
	final private long time;
	final private int size;
	final private float themeModifier;
	private Long score = null;

	public HighScore(long time, int size, float themeModifier) {
		this.time = time;
		this.size = size;
		this.themeModifier = themeModifier;
	}

	public int compareTo(HighScore arg0) {
		return arg0.getScore().compareTo(getScore());
	}

	public String getInitials() {
		return initials;
	}

	public Long getScore() {
		if (score == null) {
			score = new Double(getScoreTime()*themeModifier*getScoreSize()*SCORE_MAX).longValue();
		}
		return score;
	}

	private double getScoreSize() {
		double score = 100;
		switch (size) {
		default:
		case 7:
			score = 31;
			break;
		case 8:
			score = 54;
			break;
		case 9:
			score = 81;
			break;
		case 10:
			score = 100;
			break;
		}
		return score/100;
	}
	
	private double getScoreTime() {
		double score = time/1000;
		return 1/score;
	}

	public int getSize() {
		return size;
	}

	public float getThemeModifier() {
		return themeModifier;
	}

	public long getTime() {
		return time;
	}

	public void setInitials(String initials) {
		initials = initials.trim().toUpperCase();
		if (initials.length() > 10) {
			initials = initials.substring(0, 10);
		}
		this.initials = initials;
	}

}