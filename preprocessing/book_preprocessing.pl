my $file = 'books.csv';
my $authorfile = "Authors.csv";
my $bookfile = "book.tsv";
my $book_authorfile = "book_authors.csv";

open(my $fh, '<', $file) or die "Can't read file '$file' [$!]\n";
open(my $fhbook,'>', $bookfile);
open(my $fhauthor,'>', $authorfile);
open(my $fhba,'>', $book_authorfile);

my $authorid=1;

my %authorHash;
while (my $line = <$fh>) {
    chomp $line;

	
	
	my $wline=$line;
	if($wline=~/ISBN(.*)/){
	}
	else{
	
	
	
	
	if($wline=~/(.*)\&amp\;(.*)/ )
	{
   
	$wline=~s/\&amp\;/\&/g;
	}
	my @fields = split("\t", $wline);
	
	
	
	my $isbn = $fields[1];
	my $title = $fields[2];
	my $Author = $fields[3];
	
	my $cover=$fields[4];
	my $publisher=$fields[5];
	my $pages = $fields[6];
	my $Available = 1;
	my $data=$isbn."\t".$title."\t".$publisher."\t".$pages."\t".$cover."\t".$Available;
	 
	
	print $fhbook $data;
	print $fhbook "\n";
		
		
	my %rauthorHash = reverse %authorHash;	
	if ($Author=~/(.*),(.*)/)
	{
		my @AuthorArray = split(",",$Author);
		my $authorlength = @AuthorArray;
		
		
		
		for (my $i=0;$i<$authorlength;$i++)
		{
			
			my $key = $rauthorHash{$AuthorArray[$i]} if defined $rauthorHash{$AuthorArray[$i]};
			
			#my ($key) = grep {$Author ~~ $AuthorHash{$_}} keys %AuthorHash;
			
			#print %AuthorHash;
			#print @{[%AuthorHash]};
			#print $key."-->".$AuthorArray[i];
			if ($key ne "")
			{
			
				
				#my $key = $rauthorHash{$AuthorArray[i]} ;
				#my $author_data=$key.",".$AuthorArray[i];
				my $book_author_data=$key.",".$isbn;
				#print $fhauthor $author_data;
				#print $fhauthor "\n";
				
				print $fhba $book_author_data;
				print $fhba "\n";
			}
			else{
			
				$authorHash{$authorid}=$AuthorArray[$i];
				my $author_data=$authorid.",".$AuthorArray[$i];
				my $book_author_data=$authorid.",".$isbn;
				$authorid++;
				print $fhauthor $author_data;
				print $fhauthor "\n";
				
				print $fhba $book_author_data;
				print $fhba "\n";
			}
		}
	
	}
	else
	{
			#my %rauthorHash = reverse %authorHash;
			my $key = $rauthorHash{$Author} if defined $rauthorHash{$Author};
			
			#my ($key) = grep {$Author ~~ $AuthorHash{$_}} keys %AuthorHash;
			
			#print @{[%AuthorHash]};
			#print $key."-->".$Author;
			if ($key ne ""){
			
				#my %rauthorHash = reverse %authorHash;
				#my $key = $rauthorHash{$Author};
				#my $author_data=$key.",".$Author;
				my $book_author_data=$key.",".$isbn;
				#print $fhauthor $author_data;
				#print $fhauthor "\n";
				
				print $fhba $book_author_data;
				print $fhba "\n";
			
			}
			else{
				$authorHash{$authorid}=$Author;
				my $author_data=$authorid.",".$Author;
				my $book_author_data=$authorid.",".$isbn;
				$authorid++;
				print $fhauthor $author_data;
				print $fhauthor "\n";
			
				print $fhba $book_author_data;
				print $fhba "\n";
			
			}
			#my $authormatch=grep {$authorHash{$_} eq $Author} keys %authorHash;
			#print $authormatch;
			
			
			#my $author_data=$authorid.",".$AuthorArray[$i];		
	
	}
	

	}
	
}

close $fh;
close $fhauthor;
close $fhba;
close $fhbook;





