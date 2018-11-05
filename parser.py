from urllib.request import urlopen
from bs4 import BeautifulSoup
import requests
import sys

class DegreeRequirements:

	def __init__(self, major, classes):
		self.name = major
		self.courses = classes.copy()
	

if __name__ == '__main__':
	#Normal degrees hold the part of the URL for degrees that have similar HTML set up. The URL for all of these is www.augsburg.edu/{INSERT_COURSE}/degree-requirements
	#Psychology doesn't account for any concentrations
	normal_degrees = ["ais", "art", "chemistry", "cs", "economics", "economics", "english", "environmental", "womensstudies", "hpe", "languages", "mathematics", "philosophy", "physics",  "politicalscience", "psychology", "religion", "socialwork/academics", "sociology", "theater", "urban"] 

	#Other degrees all have a similar HTML format, where they have links to sub degrees.
	other_degrees = ["biology", "business", "communication", "music"]
	degrees = []

	#Education major is suuuuuuper wacky and not at all uniform.
	#History is also wonky.
	#Medieval Studies ends in /program-details/

	for i in range(len(normal_degrees) - 1): #loops for all degrees
		url = "http://www.augsburg.edu/" + normal_degrees[i] + "/degree-requirements"
		#properly appends the URL for a major
		#print("Page: ", url)
		page_response = requests.get(url, timeout=5)
		page_content = BeautifulSoup(page_response.content, "html.parser")
		#gets the page

		majors = page_content.find(class_='entry-content')
		#finds the proper div

		major_titles = majors.find("h2").text
		#print("Number of majors: ", len(major_titles))
		#print("             ", major_titles)
		textContent = []
		for j in range(len(major_titles)): #loops for all major titles for a given major
			heading = majors.find("h2").text
			textContent.append(heading)
			classes = []
			classes.append(majors.find('ul').text)
			#print("                    ", classes[0])
			
			degree_requirements = DegreeRequirements(heading, classes)
			degrees.append(degree_requirements)
			#print("DegreeRequirements -----------------", degree_requirements)
			#print(degrees[1].name, degrees[1].courses)

	for i in range(len(degrees)-1):
		print("----------", degrees[i].name, "----------")
		print("         ", "\n".join(degrees[i].courses))