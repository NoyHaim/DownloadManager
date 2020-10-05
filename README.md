# DownloadManager

Download manager, supports:  
- Resume 
- Concurrent connections (multiple HTTP connections) 
- Multi-server download (fetching different parts of the file from different servers)

Args:
- [0]- URL (file link- or a list of links in case of multi-server download)
- [1]- Number of parallel HTTP connections (optional).


Classes:
- Chunk - Represents a small part of the file's data (in bytes), includes the start position of the data in the file
and its size.
- HTTPRangeGetter- Represents a "worker" which receives a block to read (with start and end points from the file) 
and downloads it using the link as Chunk units and inserts each Chunk to a queue.
- Writer - Responsible for reading the chunks the HTTPRangeGetter(s) insert, from the Q. 
For each chunk, the Writer write it to the file and updates the metadata file that this chuck has been written.
- Manager - Responsible for starting the Writer and the HTTPRangeGetter threads and decides for each 
HTTPRangeGetter the block it should work on.

