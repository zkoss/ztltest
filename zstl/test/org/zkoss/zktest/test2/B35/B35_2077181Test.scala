/* B35_2077181Test.scala

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
package org.zkoss.zktest.test2.B35

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * A test class for bug 2077181
 * @author ldnigro
 *
 */
@Tags(tags = "B35-2077181.zul,B,E,Window,Tabbox")
class B35_2077181Test extends ZTL4ScalaTestCase {
	
  def testClick() = {
    val zscript = """
<?xml version="1.0" encoding="UTF-8"?>
<?page id="testZul" title=" New ZUL Title" cacheable="false" 
	language="xul/html" zscriptLanguage="Java" contentType="text/html;charset=UTF-8"?>
<?init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"?>
<!--
B35-2077181.zul

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
		Fri Aug 29 16:46:58 TST 2008, Created by Flyworld
}}IS_NOTE

Copyright (C) 2008 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
-->
<!-- edited with XML Spy v4.3 U (http://www.xmlspy.com) by Robert (dada) -->

<zk xmlns="http://www.zkoss.org/2005/zul" xmlns:h="http://www.w3.org/1999/xhtml" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://www.zkoss.org/2005/zul/zul.xsd">  
  1. Click doPupup , then the window should show up quickly (less then 3 sec) <h:br />
  2. Click do Embedded , then the window should back to original position correctly <h:br />
  <button id="popup" label="doPupup" onClick="win.doPopup()"/>
  <button id="embed" label="doEmbedded" onClick="win.doEmbedded()"/>
  <window id="win" title="Test Tabbox normal" border="normal" height="500px" width="800px" sizable="true">
    <tabbox width="100%" >
      <tabs>
        <tab label="Tab 1"/>
        <tab label="Tab 2"/>
        <tab label="Tab 3"/>
        <tab label="Tab 4"/>
        <tab label="Tab 5"/>
        <tab label="Tab 6"/>
        <tab label="Tab 7"/>
        <tab label="Tab 8"/>
        <tab label="Tab 9"/>
        <tab label="Tab 10"/>
        <tab label="Tab 11"/>
        <tab label="Tab 12"/>
        <tab label="Tab 13"/>
        <tab label="Tab 14"/>
        <tab label="Tab 15"/>
        <tab label="Tab 16"/>
        <tab label="Tab 17"/>
        <tab label="Tab 18"/>
        <tab label="Tab 19"/>
        <tab label="Tab 20"/>
        <tab label="Tab 21"/>
        <tab label="Tab 22"/>
        <tab label="Tab 23"/>
        <tab label="Tab 24"/>
        <tab label="Tab 25"/>
        <tab label="Tab 26"/>
        <tab label="Tab 27"/>
        <tab label="Tab 28"/>
        <tab label="Tab 29 - Test Some Text Here"/>
        <tab label="Tab 30"/>
        <tab label="Tab 31"/>
        <tab label="Tab 32"/>
        <tab label="Tab 33"/>
        <tab label="Tab 34"/>
        <tab label="Tab 35"/>
        <tab label="Tab 36"/>
        <tab label="Tab 37"/>
        <tab label="Tab 38"/>
        <tab label="Tab 39"/>
        <tab label="Tab 40"/>
        <tab label="Tab 41"/>
        <tab label="Tab 42"/>
        <tab label="Tab 43"/>
        <tab label="Tab 44"/>
        <tab label="Tab 45"/>
        <tab label="Tab 46"/>
        <tab label="Tab 47"/>
        <tab label="Tab 48"/>
        <tab label="Tab 49"/>
        <tab label="Tab 50"/>
        <tab label="Tab 51"/>
        <tab label="Tab 52"/>
        <tab label="Tab 53"/>
        <tab label="Tab 54"/>
        <tab label="Tab 55"/>
        <tab label="Tab 56"/>
        <tab label="Tab 57"/>
        <tab label="Tab 58"/>
        <tab label="Tab 59"/>
      </tabs>
      <tabpanels>
        <tabpanel>Tpanel 1 - Testing a long text PETER Costello and Brendan Nelson have attended the opening of the new Senate together, sparking renewed speculation about the former treasurer's future.
Mr Costello, who returned to the backbench after last year's election loss, returned to Parliament this week ahead of the release of his political memoirs next month.

Today he attended the traditional opening of the Senate with Dr Nelson, putting on a show of unity as the pair laughed and joked during ceremony.

Mr Costello is widely believed to be backing Dr Nelson's leadership against any potential challenge by treasury spokesman Malcolm Turnbull.

His dislike of Mr Turnbull has even sparked speculation if Mr Costello was to claim the leadership he may dump Mr Turnbull from the treasury portfolio, providing the key post as a consolation prize to Brendan Nelson if he fell on his sword.

While Mr Costello has ruled out a leadership challenge, his refusal to restate his intention to leave Parliament and pursue a private sector career or discuss whether he would be drafted into the leadership has prompted some MPs to encourage him to put up or shut up.


Labor's John Hogg was today elected president of the Senate, defeating the only other nomination, Christine Milne, from the Australian Greens.

Today's ceremony was also repeatedly interrupted as another guest SA Labor MP Nick Champion struggled to switch off his mobile phone that filled the chamber with the sound of the cult 1960s television program Hawaii Five-0.</tabpanel>
        <tabpanel>Tpanel 2</tabpanel>
        <tabpanel>Tpanel 3</tabpanel>
        <tabpanel>Tpanel 4</tabpanel>
        <tabpanel>Tpanel 5</tabpanel>
        <tabpanel>Tpanel 6</tabpanel>
        <tabpanel>Tpanel 7</tabpanel>
        <tabpanel>Tpanel 8</tabpanel>
        <tabpanel>Tpanel 9</tabpanel>
        <tabpanel>Tpanel 10</tabpanel>
        <tabpanel>Tpanel 11</tabpanel>
        <tabpanel>Tpanel 12</tabpanel>
        <tabpanel>Tpanel 13</tabpanel>
        <tabpanel>Tpanel 14</tabpanel>
        <tabpanel>Tpanel 15</tabpanel>
        <tabpanel>Tpanel 16</tabpanel>
        <tabpanel>Tpanel 17</tabpanel>
        <tabpanel>Tpanel 18</tabpanel>
        <tabpanel>Tpanel 19</tabpanel>
        <tabpanel>Tpanel 20</tabpanel>
        <tabpanel>Tpanel 21</tabpanel>
        <tabpanel>Tpanel 22</tabpanel>
        <tabpanel>Tpanel 23</tabpanel>
        <tabpanel>Tpanel 24</tabpanel>
        <tabpanel>Tpanel 25</tabpanel>
        <tabpanel>Tpanel 26</tabpanel>
        <tabpanel>Tpanel 27</tabpanel>
        <tabpanel>Tpanel 28</tabpanel>
        <tabpanel>Tpanel 29</tabpanel>
        <tabpanel>Tpanel 30</tabpanel>
        <tabpanel>Tpanel 31</tabpanel>
        <tabpanel>Tpanel 32</tabpanel>
        <tabpanel>Tpanel 33</tabpanel>
        <tabpanel>Tpanel 34</tabpanel>
        <tabpanel>Tpanel 35</tabpanel>
        <tabpanel>Tpanel 36</tabpanel>
        <tabpanel>Tpanel 37</tabpanel>
        <tabpanel>Tpanel 38</tabpanel>
        <tabpanel>Tpanel 39</tabpanel>
        <tabpanel>Tpanel 40</tabpanel>
        <tabpanel>Tpanel 41</tabpanel>
        <tabpanel>Tpanel 42</tabpanel>
        <tabpanel>Tpanel 43</tabpanel>
        <tabpanel>Tpanel 44</tabpanel>
        <tabpanel>Tpanel 45</tabpanel>
        <tabpanel>Tpanel 46</tabpanel>
        <tabpanel>Tpanel 47</tabpanel>
        <tabpanel>Tpanel 48</tabpanel>
        <tabpanel>Tpanel 49</tabpanel>
        <tabpanel>Tpanel 50 - PETER Costello and Brendan Nelson have attended the opening of the new Senate together, sparking renewed speculation about the former treasurer's future.
Mr Costello, who returned to the backbench after last year's election loss, returned to Parliament this week ahead of the release of his political memoirs next month.

Today he attended the traditional opening of the Senate with Dr Nelson, putting on a show of unity as the pair laughed and joked during ceremony.

Mr Costello is widely believed to be backing Dr Nelson's leadership against any potential challenge by treasury spokesman Malcolm Turnbull.


Labor's John Hogg was today elected president of the Senate, defeating the only other nomination, Christine Milne, from the Australian Greens.

Today's ceremony was also repeatedly interrupted as another guest SA Labor MP Nick Champion struggled to switch off his mobile phone that filled the chamber with the sound of the cult 1960s television program Hawaii Five-0.</tabpanel>
        <tabpanel>Tpanel 51 -PETER Costello and Brendan Nelson have attended the opening of the new Senate together, sparking renewed speculation about the former treasurer's future.
Mr Costello, who returned to the backbench after last year's election loss, returned to Parliament this week ahead of the release of his political memoirs next month.

Today he attended the traditional opening of the Senate with Dr Nelson, putting on a show of unity as the pair laughed and joked during ceremony.

Mr Costello is widely believed to be backing Dr Nelson's leadership against any potential challenge by treasury spokesman Malcolm Turnbull.

His dislike of Mr Turnbull has even sparked speculation if Mr Costello was to claim the leadership he may dump Mr Turnbull from the treasury portfolio, providing the key post as a consolation prize to Brendan Nelson if he fell on his sword.

While Mr Costello has ruled out a leadership challenge, his refusal to restate his intention to l
Labor's John Hogg was today elected president of the Senate, defeating the only other nomination, Christine Milne, from the Australian Greens.

Today's ceremony was also repeatedly interrupted as another guest SA Labor MP Nick Champion struggled to switch off his mobile phone that filled the chamber with the sound of the cult 1960s television program Hawaii Five-0.</tabpanel>
        <tabpanel>Tpanel 52</tabpanel>
        <tabpanel>Tpanel 53</tabpanel>
        <tabpanel>Tpanel 54</tabpanel>
        <tabpanel>Tpanel 55</tabpanel>
        <tabpanel>Tpanel 56</tabpanel>
        <tabpanel>Tpanel 57</tabpanel>
        <tabpanel>Tpanel 58</tabpanel>
        <tabpanel>Tpanel 59</tabpanel>
      </tabpanels>
    </tabbox>
  </window>
</zk>

    """

    runZTL(zscript,
        () => {
        	
        	var lb=jq("$popup").offsetLeft();
        	var tb=jq("$popup").offsetTop();
          
            //click popup button
            click(jq("$popup"));
            
            var st=System.currentTimeMillis();
        	waitResponse();
        	var end=System.currentTimeMillis()-st;
        	
        	var la=jq("$popup").offsetLeft();
        	var ta=jq("$popup").offsetTop();
        	verifyEquals(lb,la);
        	verifyEquals(tb,ta);
        	
        	//Window is popup, response time < 3 seconds
        	verifyTrue(jq(".z-window-popup").isVisible());
        	verifyTrue(end<3000);
        	
        	//click Embedded button
        	click(jq("$embed"));
        	
            waitResponse();
            
            //Window is popup, response time < 3 seconds
        	verifyTrue(jq(".z-window-embedded").isVisible());
            
        	var la1=jq("$popup").offsetLeft();
        	var ta1=jq("$popup").offsetTop();
        	verifyEquals(lb,la1);
        	verifyEquals(tb,ta1);
        	
        }
    );
   }
}
