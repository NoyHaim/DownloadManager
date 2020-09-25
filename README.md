# DownloadManager

Download manager, supports:  
- Resume 
- Concurrent connections (multiple HTTP connections) 
- Multi-server download (fetching different parts of the file from different servers)

Args:
- [1]- URL(file link)
- [2]- Number of parallel HTTP connections.


Classes:
- Chunk - Represent a small part of the file's data (in bytes), include the start position of the data in the file
and its size.
- HTTPRangeGetter- Represent a "worker" which receives a block to read (with start and end points from the file) 
and downloads it from the link as Chunk units and insert each Chunk to a Queue.
- Writer- Responsible for reading the chunks the HTTPRangeGetter(s) insert, from the Q. For each chunk, 
the writer write it to the file and update the metadata file that this chuck has been written.
- Manager- Responsible for starting the writer and the HTTPRangeGetter threads and to decide for each 
HTTPRangeGetter which block should it work on.

