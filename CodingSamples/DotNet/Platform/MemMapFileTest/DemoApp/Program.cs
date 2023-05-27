using System.IO.MemoryMappedFiles;

var doc = new FileInfo(args[0]);
using var mapping = MemoryMappedFile.CreateFromFile(doc.FullName);
using var buffer = mapping.CreateViewAccessor(0, doc.Length);
Transformer.Transform(buffer);
