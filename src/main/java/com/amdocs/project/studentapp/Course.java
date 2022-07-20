package com.amdocs.project.studentapp;

import java.util.Objects;

public class Course {

	private int c_id;
	private String c_name;
	private int c_duration;
	private int c_fee;
	
	public Course() {}

	public Course(int c_id, String c_name, int c_duration, int c_fee) {
		super();
		this.c_id = c_id;
		this.c_name = c_name;
		this.c_duration = c_duration;
		this.c_fee = c_fee;
	}

	public int getC_id() {
		return c_id;
	}

	public void setC_id(int c_id) {
		this.c_id = c_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public int getC_duration() {
		return c_duration;
	}

	public void setC_duration(int c_duration) {
		this.c_duration = c_duration;
	}

	public int getC_fee() {
		return c_fee;
	}

	public void setC_fee(int c_fee) {
		this.c_fee = c_fee;
	}
	
	public String toString() {
		return c_name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(c_duration, c_fee, c_id, c_name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return c_duration == other.c_duration && c_fee == other.c_fee && c_id == other.c_id
				&& Objects.equals(c_name, other.c_name);
	}
	
}
