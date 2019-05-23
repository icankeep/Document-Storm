/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.passer.utils.convert;

import java.io.IOException;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

/**
 * @Description: PDF合并类,将多个PDF合并为一个,目前没有使用,存档待后续使用<p>
 * @author: passer<p>
 * @version：2019年5月18日 下午1:42:17<p>
 */
public final class PDFMerger {

	private PDFMerger() {
	}

	/**
	 * Infamous main method.
	 *
	 * @param args Command line arguments, should be at least 3.
	 *
	 * @throws IOException If there is an error parsing the document.
	 */
	public static void main(String[] args) throws IOException {
		// suppress the Dock icon on OS X
		System.setProperty("apple.awt.UIElement", "true");

		PDFMerger merge = new PDFMerger();
		merge.merge(args);
	}

	private void merge(String[] args) throws IOException {
		int firstFileArgPos = 0;

		if (args.length - firstFileArgPos < 3) {
			usage();
		}

		PDFMergerUtility merger = new PDFMergerUtility();
		for (int i = firstFileArgPos; i < args.length - 1; i++) {
			String sourceFileName = args[i];
			merger.addSource(sourceFileName);
		}

		String destinationFileName = args[args.length - 1];
		merger.setDestinationFileName(destinationFileName);
		merger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
	}

	/**
	 * This will print the usage requirements and exit.
	 */
	private static void usage() {
		String message = "Usage: java -jar pdfbox-app-x.y.z.jar PDFMerger " + "<inputfiles 2..n> <outputfile>\n"
				+ "\nOptions:\n" + "  <inputfiles 2..n> : 2 or more source PDF documents to merge\n"
				+ "  <outputfile>      : The PDF document to save the merged documents to\n";

		System.err.println(message);
		System.exit(1);
	}
}
