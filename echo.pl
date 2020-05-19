#!"C:\xampp\perl\bin\perl.exe"


#0 -> Proceed
#1 -> Error

use strict;
use warnings;
use IPC::Run;
use MIME::Base64;
use Try::Tiny;

$| = 1;

while(my $accNo = <STDIN>){
	if(length($accNo) > 1){
		$accNo = substr $accNo, 0 , (length($accNo) - 1);
		my $cmd = "";
		my $res = "";
		
		$cmd = "java -jar C:/xampp/cgi-bin/Authorize11Monitor.jar \"$accNo\"";
		$res = qx/$cmd/;
		
		print "$res\n";
		
		
	} else {
		printf "1\n";
	}
	
}
