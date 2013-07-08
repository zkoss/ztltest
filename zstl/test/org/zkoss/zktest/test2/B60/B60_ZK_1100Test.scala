package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1100.zul")
class B60_ZK_1100Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript = """<zk>
                    <zscript>
                      String image1 = "/img/Centigrade-Widget-Icons/ArrowDown-16x16.png";
		String image2 = "/img/Centigrade-Widget-Icons/ArrowLeft-16x16.png";

		void changeImage(boolean setMenuImage){

                        miImage.setImage(image2);
                        miImage2.setImage(image2);
                        if (setMenuImage) {
                          menuImage.setImage(image2);
                          menuImage.setHoverImage("/img/Centigrade-Widget-Icons/ArrowLeftGreen-16x16.png");
                        }
                      }
                    </zscript>
                    <div>1. Click 'Image' then 'setImage', the image if 'setImage' should changed from down arrow to left arrow.</div>
                    <div>2. Click 'Image' then 'setImage2', the image of 'Image' should changed from down arrow to left arrow.</div>
                    <div></div>
                    <menubar id="menubar">
                      <menuitem id="miImage" image="${image1}" hoverImage="/img/Centigrade-Widget-Icons/ArrowLeftGreen-16x16.png"/>
                      <menu label="Image" id="menuImage">
                        <menupopup>
                          <menuitem id="miImage2" label="setImage" onClick="changeImage(false)" hoverImage="/img/Centigrade-Widget-Icons/ArrowLeftGreen-16x16.png" image="${image1}"/>
                          <menuitem label="setImage2" onClick="changeImage(true)" hoverImage="/img/Centigrade-Widget-Icons/ArrowLeftGreen-16x16.png" image="${image1}"/>
                        </menupopup>
                      </menu>
                    </menubar>
                  </zk>"""

    runZTL(zscript,
      () => {
        val menu = jq(".z-menu:contains(Image)")
        click(menu)
        waitResponse()
        click(jq(".z-menuitem:contains(setImage)"))
        waitResponse()

        verifyTrue("1. Click 'Image' then 'setImage', the image if 'setImage' should changed from down arrow to left arrow.", jq(".z-menuitem:eq(0) .z-menuitem-image[src*=Left]").exists())

        click(menu)
        waitResponse()
        click(jq(".z-menuitem:contains(setImage2)"))
        waitResponse()

        verifyTrue("2. Click 'Image' then 'setImage2', the image of 'Image' should changed from down arrow to left arrow.", jq(menu.toWidget().$n("img")).is("[src*=Left]"))
      })

  }
}
