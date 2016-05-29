/**
 * 
 */
package com.ideamoment.ideagen.generator;

import org.junit.Test;

/**
 * @author Chinakite Zhang
 *
 */
public class TestEclipseProjectGenerator {
	
	@Test
	public void testGenetateDotProjectFile() {
		EclipseProjectGenerator gen = new EclipseProjectGenerator();
		gen.generateDotProjectFile("testProj", null);
	}
	
	@Test
	public void testGenetateDotClasspathFile() {
		EclipseProjectGenerator gen = new EclipseProjectGenerator();
		gen.generateDotClasspathFile(null);
	}
}
