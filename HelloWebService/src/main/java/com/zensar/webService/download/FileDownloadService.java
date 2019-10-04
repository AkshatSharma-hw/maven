package com.zensar.webService.download;

import java.io.File;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;


@Path("/download")
public class FileDownloadService {
	private static final String textFile = "D:\\a.txt";
	@GET
	@Path("/text")
	@Produces("text/plain")
	public Response getTextFile() {
		File f = new File(textFile);
		ResponseBuilder builder = Response.ok(f);
		builder.header("Content-Disposition", "attachment; filename = a1.txt");
		
		return builder.build();
	}
	
	
	private static final String imgFile = "D:\\2.jpg"; 
	@GET
	@Path("/image")
	@Produces("image/jpg")
	public Response getImgFile() {
		File f = new File(imgFile);
		ResponseBuilder builder = Response.ok(f);
		builder.header("Content-Disposition", "attachment; filename = 2download.jpg");
		
		return builder.build();
		
	}
	
	private static final String pdfFile = "D:\\grab_jobs.pdf"; 
	@GET
	@Path("/pdf")
	@Produces("application/pdf")
	public Response getPdfFile() {
		File f = new File(pdfFile);
		ResponseBuilder builder = Response.ok(f);
		builder.header("Content-Disposition", "attachment; filename = Xpdf.pdf");
		
		return builder.build();
		
	}
}
