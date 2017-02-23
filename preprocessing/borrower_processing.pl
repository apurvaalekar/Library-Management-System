my $file = 'borrowers.csv';
my $wfile = 'borrower.tsv';

open(my $fh, '<', $file) or die "Can't read file '$file' [$!]\n";
open(my $fh1, '>', $wfile);

while (my $line = <$fh>){
	if($line=~/borrower(.*)/){
	}
	else{
	chomp $line;
	#my $wline=$line;
	#print $wline;
	my @fields = split("\,",$line);
	my $borrower_id=$fields[0];
	my $Ssn=$fields[1];
	my $fname=$fields[2];
	my $lname=$fields[3];
	my $Address=$fields[5].$fields[6].$fields[7];
	
	my $phone=$fields[8];
		
	my $data = $borrower_id."\t".$Ssn."\t".$fname."\t".$lname."\t".$Address."\t".$phone;
	
	
	print $fh1 $data;
	print $fh1 "\n";
	}
}
close $fh1;
close $fh;