package org.zkoss.zktest.test2.Z60
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "Touch,Android")
class Z60_Touch_015Test extends ZTL4ScalaTestCase {
	def testClick() {
		val zscript = {
// <?meta name="viewport" content="width=800"?>
<zk>
	<n:h3 xmlns:n="native">iPad/Android</n:h3>
	1. You should see column menu arrow by default.<separator />
	2. Click on the arrow icon, it should show a pop-up menu.
	<listbox>
		<listhead menupopup="auto">
			<listheader label="Author" sort="auto"/>
			<listheader label="Title" sort="auto"/>
			<listheader label="Publisher" sort="auto"/>
			<listheader label="Hardcover" sort="auto"/>
		</listhead>
		<listitem>
			<listcell label="Philip Hensher"/>
			<listcell label="The Northern Clemency"/>
			<listcell label="Knopf (October 30, 2008)"/>
			<listcell label="608 pages"/>
		</listitem>
		<listitem>
			<listcell label="Philip Hensher"/>
			<listcell label="The Fit"/>
			<listcell label="HarperPerennial (April 4, 2005)"/>
			<listcell label="240 pages"/>
		</listitem>
		<listitem>
			<listcell label="Philip Hensher"/>
			<listcell label="Kitchen Venom"/>
			<listcell label="Flamingo (May 19, 2003)"/>
			<listcell label="336 pages"/>
		</listitem>
		<listitem>
			<listcell label="Michael Greenberg"/>
			<listcell label="Hurry Down Sunshine"/>
			<listcell label="Other Press (September 9, 2008)"/>
			<listcell label="240 pages"/>
		</listitem>
		<listitem>
			<listcell label="Michael Greenberg"/>
			<listcell label="Painless Vocabulary (Painless)"/>
			<listcell label="Barron's Educational Series (September 1, 2001)"/>
			<listcell label="292 pages"/>
		</listitem>
		<listitem>
			<listcell label="Rick Perlstein"/>
			<listcell label="Nixonland: The Rise of a President and the Fracturing of America"/>
			<listcell label="Scribner; 1st Scribner Hardcover Ed edition (May 13, 2008)"/>
			<listcell label="896 pages"/>
		</listitem>
		<listitem>
			<listcell label="Rick Perlstein"/>
			<listcell label="Nixonland"/>
			<listcell label="Simon &amp; Schuster (May 13, 2008)"/>
			<listcell label="100 pages"/>
		</listitem>
	</listbox>
</zk>			
		};
		
		runZTL(zscript,
			() => {
				var column_btns = jq(".z-listheader-btn");
				var menu_popup  = jq(".z-menupopup");
				
				for (i <- 0 to column_btns.length()-1) {
					// 1. You should see column menu arrow by default.
					var btn = column_btns.eq(i);
					verifyTrue(btn.isVisible());
					
					// 2. Click on the arrow icon, you should see a pop-up menu.
					click(btn);
					waitResponse(true);
					
					verifyTrue(menu_popup.isVisible());
				}
			}
		);
	}
}