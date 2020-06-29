package com.jar.validator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.jar.JarFile;
import java.util.stream.Collectors;

/*
 * Maven 빌드시 : 손상된 jar 파일 확인 (corrupted jar check)
 * 
 * 손상된 jar 파일의 경우 다운로드 시도.
 * 
 * 다운로드 받은 후 해당 Maven 프로젝트들은 update 해주세요.
 * 
 */
public class JarValidator {

	private static Path repositorypath = null;

	public static void main(String[] args) throws IOException {
		repositorypath = Paths.get(System.getProperty("user.home"),".m2","repository");

//		System.out.println(repositorypath);

		if(Files.exists(repositorypath)){

			JarValidator jv = new JarValidator();

			List<Path> jarFiles = jv.getFiles(repositorypath, ".jar");

			System.out.println("발견된 전체 jar 파일들: " + jarFiles.size() + " 개");

			jv.openJars(jarFiles);

		} else {
			System.out.println("Repository path : " + repositorypath + " 경로가 없습니다.");
		}
 


	}


	/**
	 * 주어진 경로에서 부터 시작하여 모든 이하 디렉토리들을 검색하여, 주어진 확장자에 일치하는 파일들의 목록 만들기.
	 * @param filePath 		: File 의 절대경로
	 * @param fileExtension : 검색할 파일의 확장자
	 * @return 디렉토리 내에 있는 모든 파일들의 List
	 */
	private List<Path> getFiles(Path filePath, String fileExtension) throws IOException {
		return Files.walk(filePath)
				.filter(p -> p.toString().endsWith(fileExtension))
				.collect(Collectors.toList());
	}


	private List<String> openJars(List<Path> jarFiles){

		final int[] badJars = {0}; // 손상된 jar 파일 개수.


		// 가각의 jar 파일에 대해 아래 수행
		jarFiles.forEach(path -> {
			String absPath = path.toAbsolutePath().toString();  // jar 파일 절대 경로

			try (
					JarFile file = new JarFile(path.toFile())
					){
				; // jar 파일 open 시도 !
			} catch (IOException e) {  // jar File open 실패하면 IOException 발생

				String errMsg = "손상 jar 발견:" + absPath + " --exception:" + e.toString();
				System.out.println(errMsg);
				badJars[0]++;
			}
		});

		System.out.println("손상된 jar 파일 개수 = " + badJars[0]);

		return null;

	}

}
