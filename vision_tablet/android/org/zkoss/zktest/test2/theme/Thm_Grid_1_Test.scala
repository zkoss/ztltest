package org.zkoss.zktest.test2.theme

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Android,VisionTest")
class Thm_Grid_1_Test extends ZTL4ScalaTestCase {
	def testClick() = {
		val zscript = """
<zk>
	<zscript>
	import java.util.Comparator;
	
	public class RowDetailComparator implements Comparator {
		private boolean _asc;
		
		public RowDetailComparator(boolean asc) {
			_asc = asc;
		}
		
		public int compare(Object o1, Object o2) {
			String s1 = getValue(o1), s2 = getValue(o2);
			int v = s1.compareTo(s2);
			return _asc ? v: -v;
		}
		
		private String getValue(Object o) {
			return ((Label)((Component)o).getChildren().get(1)).getValue();
		}
	}
			
	asc = new RowDetailComparator(true);
	dsc = new RowDetailComparator(false);
	</zscript>

	<grid>
		<columns menupopup="auto">
			<column label="Author" sortAscending="${asc}" sortDescending="${dsc}"/>
			<column label="Title" sort="auto" />
			<column label="Publisher"/>
			<column label="Hardcover"/>
		</columns>
		<rows>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Northern Clemency"/>
				<label value="Knopf (October 30, 2008)"/>
				<label value="608 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="The Fit"/>
				<label value="HarperPerennial (April 4, 2005)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Philip Hensher"/>
				<label value="Kitchen Venom"/>
				<label value="Flamingo (May 19, 2003)"/>
				<label value="336 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Hurry Down Sunshine"/>
				<label value="Other Press (September 9, 2008)"/>
				<label value="240 pages"/>
			</row>
			<row>
				<label value="Michael Greenberg"/>
				<label value="Painless Vocabulary (Painless)"/>
				<label value="Barron's Educational Series (September 1, 2001)"/>
				<label value="292 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland: The Rise of a President and the Fracturing of America"/>
				<label value="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
				<label value="896 pages"/>
			</row>
			<row>
				<label value="Rick Perlstein"/>
				<label value="Nixonland"/>
				<label value="Simon &amp; Schuster (May 13, 2008)"/>
				<label value="0 pages"/>
			</row>
		</rows>
	</grid>
</zk>""";

		runZTL(zscript,
			() => {
				verifyImage();
				
				// Verify Column menu dropdown
				singleTap(jq(".z-column-btn:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Verify Group  
				singleTap(jq(".z-menuitem:eq(0)"));
				sleep(500);
				verifyImage();
				
				// Verify Ungroup
				singleTap(jq(".z-column-btn:eq(0)"));
				sleep(500);
				singleTap(jq(".z-menuitem:eq(1)"));
				sleep(500);
				verifyImage();
				
				// Verify Sort Ascending
				singleTap(jq(".z-column-btn:eq(0)"));
				sleep(500);
				singleTap(jq(".z-menuitem:eq(2)"));
				sleep(500);
				verifyImage();
				
				// Verify Column Hiding
				singleTap(jq(".z-column-btn:eq(0)"));
				sleep(500);
				singleTap(jq(".z-menuitem:eq(5)"));
				sleep(500);
				verifyImage();
			});
	}
}