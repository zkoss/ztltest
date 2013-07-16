package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.junit.Test

@Tags(tags = "Touch,Android")
class Z60_Touch_009Test extends ZTL4ScalaTestCase {
  
	@Test
	def testClick() {
		val zscript = {
//<?meta name="viewport" content="width=800"?>
<zk>
	<n:h3 xmlns:n="native">iPad/Android</n:h3>
	1. You should see column menu arrow by default.<separator />
	2. Click on the arrow icon, it should a pop-up menu.
	<grid>
		<columns menupopup="auto">
			<column label="Author" sort="auto"/>
			<column label="Title" sort="auto"/>
			<column label="Publisher" sort="auto"/>
			<column label="Hardcover" sort="auto"/>
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
				<label value="100 pages"/>
			</row>
		</rows>
	</grid>
</zk>			
		};
		
		runZTL(zscript,
			() => {
				var column_btns = jq(".z-column-menuicon");
				
				for (i <- 0 to column_btns.length()-1) {
					var column_btn = column_btns.eq(i);
					
					// Column menu arrows should be visible by default 
					verifyTrue(column_btn.isVisible());
					
					// Click on it
					singleTap(column_btn);
					waitResponse(true);
					
					// should bring up a pop-up menu
					verifyTrue(jq(".z-menupopup").isVisible());
					
					sleep(500);
				}
			}
		);
	}
}