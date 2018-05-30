/* B36_2635555Test.scala

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Tue Nov 08 22:51:02 GFT 2011 , Created by ldnigro
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.test2.B36

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags
import org.openqa.selenium.Keys
import org.zkoss.ztl.Widget
import org.zkoss.ztl.ZK
import org.zkoss.ztl.util.Scripts

/**
  * A test class for bug 2635555
  *
  * @author ldnigro
  *
  */
@Tags(tags = "B36-2635555.zul,B,E,Textbox,IE")
class B36_2635555Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """
<?xml version="1.0" encoding="UTF-8"?>

<!--
B36-2635555.zul

	Purpose:
		
	Description:
		
	History:
		Thu Jun  4 12:23:18     2009, Created by jumperchen

Copyright (C) 2009 Potix Corporation. All Rights Reserved.

-->
<zk>
IE only
<vbox>
<label value="1.Click the Upload button"/>
<label value="2.Click the Cancel button"/>
<label value="3.Focus into the input box, you should see a cursor is inside the input box"/>
</vbox>
<button label="Upload">
<attribute name="onClick">{
Object media = Fileupload.get(-1);
if (media instanceof org.zkoss.util.media.Media[]) {
org.zkoss.util.media.Media[] medias = (org.zkoss.util.media.Media
[])media;
for (int i = 0; i &lt; medias.length; i++) {
Image image = new Image();
image.setContent(medias[i]);
image.setParent(pics);
}
} else if (media != null)
Messagebox.show("Not an image: "+media, "Error", Messagebox.OK,
Messagebox.ERROR);
}</attribute>
</button>
<textbox id="text" onFocus='self.style="background:red;"'
onBlur='self.style="background:white"' />
</zk>

      """

    runZTL(zscript,
      () => {

        waitResponse();

        //Click upload button
        var btn = jq("@button");
        click(btn);

        waitResponse();

        //Click cancel button
        var cancel = jq("@button:last");
        click(cancel);

        waitResponse();
        var text = jq("$text");

        //Cursor is into input
        focus(text)
        waitResponse();
        var color = text.css("background-color");

        verifyTrue(color.equals("rgb(255, 0, 0)"));

      });
  }
}