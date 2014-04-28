package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "F65-ZK-1272.zul,Tablet")
class F65_ZK_1272Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
	<window title="ScrollView Demo" border="normal" vflex="1" hflex="1">
		<vlayout vflex="1" hflex="1">
		<div>
			1. Should be able to scroll the windows on vertical direction.<separator />
			2. When scrolling outside top boundary, you can see a arrow showed, scroll outside top boundary again, a groupbox will insert before window1.<separator />
			3. When scrolling outside bottom boundary, you can see a arrow showed, scroll outside bottom boundary again, a groupbox will append after window2.<separator />
			4. Click <button label="Change Orient" onClick='sv.setOrient(sv.isVertical() ? "horizontal" : "vertical")' /> button, should be able to scroll on horizontal direction.
		</div>
		<scrollview id="sv" orient="vertical" vflex="1" hflex="1">
			<attribute name="onScroll"><![CDATA[
				ScrollEvent se = (ScrollEvent) event;
				if (se.isOutOfBound() && se.getPos() > 0) {
					Groupbox gb = new Groupbox();
					gb.setId("bottom");
					gb.setHeight("200px");
					gb.setWidth("200px");
					gb.setTitle("Groupbox");
					if (sv.hasFellow("bottom"))
						return;
					sv.appendChild(gb);
				}
				if (se.isOutOfBound() && se.getPos() < 0) {
					Groupbox gb = new Groupbox();
					gb.setId("top");
					gb.setHeight("200px");
					gb.setWidth("200px");
					gb.setTitle("Groupbox");
					if (sv.hasFellow("top"))
						return;
					Component first = sv.getFirstChild();
					sv.insertBefore(gb, first);
				}
			]]></attribute>
			<menubar>
				<menu label="File">
					<menupopup>
						<menuitem label="New" onClick="alert(self.label)" />
						<menuitem label="Open" onClick="alert(self.label)" />
						<menuitem label="Save" onClick="alert(self.label)" />
						<menuseparator />
						<menuitem label="Exit" onClick="alert(self.label)" />
					</menupopup>
				</menu>
			</menubar>
			<textbox />
			<button label="button" onClick="alert(self.label)"/>
			<window title="window 1" border="normal" width="255px" height="200px">
				This is Window 1
				<textbox />
			</window>
			<window title="window 2" border="normal" width="200px" height="354px">This is Window 2</window>
		</scrollview>
		</vlayout>
	</window>
</zk>
"""
    runZTL(zscript,
      () => {
        swipeDown(jq(".z-scrollview"), 800)
        waitResponse()
        verifyTrue("a groupbox will insert before window1.", jq(".z-groupbox-3d:eq(0)").exists)
        swipeUp(jq(".z-scrollview"), 800)
        swipeUp(jq(".z-scrollview"), 800)
        waitResponse()
        verifyTrue("a groupbox will append after window2.", jq(".z-groupbox-3d:eq(1)").exists)
      })

  }
}