#!/bin/bash
if [ $1 == "safari" ]; then
	##Safari on MAC OS X
	ssh -f root@$2 shutdown -r now
else
	##Others
	net rpc shutdown -r -f -I $2 -U zktest%zktest
fi